<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Página Inicial</title>
        <link href="css/styles.css" rel="stylesheet" />

        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="/usuario" />
            <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
                <a class="navbar-brand" href="index.html">Vem com o braço!</a>
                <!-- Navbar Search-->
                <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                    <a href='Sair'>Sair</a>
                </form>
            </nav>
            <div id="layoutSidenav">
                <div id="layoutSidenav_nav">
                    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                        <div class="sb-sidenav-menu">
                            <div class="nav">
                                <a class="nav-link" href="index.html">
                                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                    Página Inicial
                                </a>
                                <div class="sb-sidenav-menu-heading">USUÁRIO</div>
                                <a class="nav-link" href="cadastrousuario.jsp">
                                    <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                                    Cadastrar Usuário
                                </a>
                                <a class="nav-link" href="listarUsuario.jsp">
                                    <div class="sb-nav-link-icon"><i class="fas fa-users"></i></div>
                                    Listar Usuários
                                </a>
                                <div class="sb-sidenav-menu-heading">POSTO DE ATENDIMENTO</div>
                                <a class="nav-link" href="listarubs.jsp">
                                    <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                                    Cadastrar UBS
                                </a>
                                <a class="nav-link" href="cadastroubs.jsp">
                                    <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                                    Listar UBS
                                </a>
                            </div>
                        </div>
                    </nav>
                </div>
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid">
                            <h1 class="mt-4"></h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item active"></li>
                            </ol>
                            <div class="row">
                                <div class="col-xl-12 col-md-12">
                                    <form>
                                        <div class="row">
                                            <div class="col-xl-12 col-md-12">
                                                <h1>Listar Usuários</h1>
                                                <table>
                                                    <tr>
                                                        <th width="100">Nome</th>
                                                        <th width="200">Email</th> 
                                                        <th width="200"></th> 
                                                    </tr>  
                                                <c:forEach var="user" items="${users}">
                                                    <tr>      
                                                        <td>${user.getNome() }</td>
                                                        <td>${user.getEmail() }</td> 
                                                        <td><a class="btn btn-warning" href="cadastrousuario.jsp" role="button">Editar</a>--></td> 
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                    </div>
                                </form>
                                <!--<a class="btn btn-primary" href="cadastrousuario.jsp" role="button">Cadastrar Usuário</a>-->
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
    </body>
</html>
