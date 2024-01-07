﻿/**
    Programa Simples que lê os valores de vendas de arquivos e os totaliza em um novo arquivo.

**/ 

using Newtonsoft.Json;


// Pega o diretório atual
var currentDirectory = Directory.GetCurrentDirectory();

// Cria uma caminho (Path) do diretório atual combinado com o diretório stories
var storesDirectory = Path.Combine(currentDirectory, "stores");

// Cria um caminho (Path) do diretório atual combinado com o diretório salesTotalDir
var salesTotalDir = Path.Combine(currentDirectory, "salesTotalDir");

// Cria o diretório conforme o Path criado para a variável salesTotalDir
Directory.CreateDirectory(salesTotalDir);

// Cria um arquivo totais.txt vazio dentro do diretório salesTotalDir
File.WriteAllText(Path.Combine(salesTotalDir, "totais.txt"), String.Empty);

// Cria uma variável que será uma lista que guardará todos os arquivos contidos no diretório
var salesFiles = FindFiles(storesDirectory);

// Lê o conteúdo do arquivo sales.json e atribui à variável salesJson
//var salesJson = File.ReadAllText($"stores{Path.DirectorySeparatorChar}201{Path.DirectorySeparatorChar}sales.json");

// Chama a função que calcula o total de vendas, conforme a leitura de casa arquivo
var salesTotal = CalculateSalesTotal(salesFiles);

// Grava o contúdo do total de venda no arquivo totais criado anteriormente
//File.WriteAllText($"salesTotalDir{Path.DirectorySeparatorChar}totals.txt", salesTotal.ToString());
File.AppendAllText(Path.Combine(salesTotalDir,"totais.txt"), $"{salesTotal}{Environment.NewLine}");



IEnumerable<string> FindFiles(string folderName)
{
    /*
        Função responsável por buscar arquivos dado um diretório
        Recebe uma pasta (diretório) que é um path string
    */
    
    
    //Declara uma variável do tipo lista de strings para guardar os nomes dos arquivos
    List<string> salesFiles = new List<string>();

    // Utiiza o método EnumerateFiles paera 
    var foundFiles = Directory.EnumerateFiles(folderName, "*", SearchOption.AllDirectories);

    
    //Percorre a lista foudFiles e adiciona o arquivo corrente caso tenha a extensão .json 
    foreach (var file in foundFiles)
    {
        // Verifica se a extensão é .json
        if (Path.GetExtension(file) == ".json")
        {

            salesFiles.Add(file);
        }
    }

    return salesFiles;
}


double CalculateSalesTotal(IEnumerable<string> salesFiles)
{
    double salesTotal = 0;

    // Iterando a lista salesFiles recebida como parâmetro
    foreach (var file in salesFiles)
    {      
        // Lendo o conteúdo do arquivo corrente (arqquivo em questão é um Json)
        string salesJson = File.ReadAllText(file);

        // Fazendo o parse do json lido para uma variável data
        // O uso de '?' significa que a variável data pode ser nula no caso do valor lido no arquivo ser nulo.
        SalesData? data = JsonConvert.DeserializeObject<SalesData?>(salesJson);

        // Somando o valor encontrado ao total.
        // Aqui também é feito o uso de '?' para verificar se a variável data é nula
        // Já o '??' é para em caso da variável ser nula, atribuir 0.
        salesTotal += data?.Total ?? 0;
    }

    return salesTotal;
}


// Record para representar a estrutura de dados de um arquivo
record SalesData (double Total);

