module desafio {
	exports br.com.imagemfilmes.desafio.dao;
	exports br.com.imagemfilmes.desafio.service;
	exports br.com.imagemfilmes.desafio.controller;
	exports br.com.imagemfilmes.desafio;
	exports br.com.imagemfilmes.desafio.entity;
	requires com.zaxxer.hikari;
	requires spring.web;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires java.sql;
}