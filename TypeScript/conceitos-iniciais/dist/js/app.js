import { Negociacao } from "./models/negociacao.js";

const negociacao = new Negociacao(new Date(), 10, 100);

console.log(negociacao.data);
console.log(negociacao.quantidade);

negociacao.quatidade = 1000;

console.log(negociacao.data);
console.log(negociacao.valor);
console.log(negociacao.quantidade);