import { Negociacao } from "./models/negociacao.js";

const negociacao = new Negociacao(new Date(), 10, 100);

console.log(negociacao.data);
console.log(negociacao.quantidade);

//negociacao.quantidade = 1000;

console.log(negociacao.data);
console.log(negociacao.valor);
console.log(negociacao.volume);
console.log(negociacao.volume * 2);
alert("O volume x 2 é: " + negociacao.volume * 2)