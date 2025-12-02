import {Request, Response} from 'express';
import {Cliente} from '../models/Cliente';
import ClienteRepository from '../repositories/ClienteRepository';


export default class ClienteController {

    async create(req: Request, res: Response) {
        if(!req.body.cpf) {
            return res.status(400).send({message: "CPF é obrigatório! O cliente não foi criado."});
        }

        try {
            const cliente: Cliente = req.body;
            const novoCliente = await ClienteRepository.create(cliente);
            return res.status(201).json(novoCliente);
        }catch (error) {
            return res.status(500).json({ message: (error as Error).message + "\nErro ao tentar salvar um cliente."});
        }
    }

    async retrieveAll(req: Request, res: Response) {
        try {
            const clientes = await ClienteRepository.retrieveAll();
            return res.status(200).json(clientes);
        } catch (error) {
            return res.status(500).json({ message: (error as Error).message + "\nErro ao tentar recuperar os clientes."});
        }
    }

    async retrieveByCPF(req: Request, res: Response) {
        const cpf: string|undefined = req.params.cpf;
        try {
            const cliente = await ClienteRepository.retrieveByCPF(cpf);
            if(cliente) return res.status(200).json(cliente);
            else
                res.status(404).send({
                    message: `Não foi encontrado nenhum cliente com esse cpf=${cpf}.`
                });
        } catch (error) {
            return res.status(500).json({ message: (error as Error).message + "\nErro ao tentar recuperar o cliente."});
        }
    }

    async update(req: Request, res: Response) {
        const cpf: string|undefined = req.params.cpf;
        const cliente: Cliente = req.body;
        try {
            const clienteExistente = await ClienteRepository.retrieveByCPF(cpf);
            if(clienteExistente) {
                await ClienteRepository.update(cliente);
                return res.status(200).json({message: "Cliente atualizado com sucesso!"});
            }
            else {
                return res.status(404).send({
                    message: `Não foi encontrado nenhum cliente com esse cpf=${cpf}.`
                });
            }
        } catch (error) {
            return res.status(500).json({ message: (error as Error).message + "\nErro ao tentar atualizar o cliente."});
        }
    }

    async delete(req: Request, res: Response) {
        const cpf: string|undefined = req.params.cpf;
        try {
            const clienteExistente = await ClienteRepository.retrieveByCPF(cpf);
            if(clienteExistente) {
                const mensagem = await ClienteRepository.delete(clienteExistente.cpf);
                return res.status(200).json({message: mensagem});
            } else {
                return res.status(404).send({
                    message: `Não foi encontrado nenhum cliente com esse cpf=${cpf}.`
                });
            }
        } catch (error) {
            return res.status(500).json({ message: (error as Error).message + "\nErro ao tentar deletar o cliente."});
        }
    }

    async deleteAll(req: Request, res: Response) {
        try {
            const num = await ClienteRepository.deleteAll();
            return res.status(200).json({message: `Foram deletados ${num} clientes.`});
        } catch (error) {
            return res.status(500).json({ message: (error as Error).message + "\nErro ao tentar deletar todos os clientes."});
        }
    }

}