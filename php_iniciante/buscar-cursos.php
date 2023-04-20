<?php
require 'vendor/autoload.php';

use GuzzleHttp\Client;
use Symfony\Component\DomCrawler\Crawler;

$client = new Client(['verify' => false]);

$response = $client->request('GET', 'https://www.alura.com.br/escola-programacao');

$html = $response->getBody();

echo($html);

$crawler = new Crawler();
$crawler->addHtmlContent($html);