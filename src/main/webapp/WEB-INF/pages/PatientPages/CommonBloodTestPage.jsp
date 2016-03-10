<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title></title>
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap-datepicker/datepicker/css/datepicker.css"/>"/>
</head>
<body style="padding-top: 70px;">
<c:url var="addCommonBloodTest" value="/addCommonBloodTest"/>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <div class="navbar-brand">LaksmiMed</div>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="<c:url value="/main"/>">Главная</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Сайт <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="<c:url value="/about"/>">О сайте</a></li>
          <li><a href="<c:url value="/help"/>">Помощь</a></li>
        </ul>
      </li>
      <li><a href="<c:url value="/beforeTreatmentStatVisualization"/>">Статистика</a></li>
      <li><a href="<c:url value="/patientList"/>">Пациенты</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="<c:url value="/personalPage"/>">Личная страница</a></li>
      <li><a href="<c:url value="/logout"/>">Выйти</a></li>
    </ul>
  </div>
</nav>
<div class="container">
  <fieldset>
    <legend>Общий анализ крови</legend>
    <form:form cssClass="form-horizontal" method="post" action="${addCommonBloodTest}" modelAttribute="commonBloodTest">
      <div class="row">
        <div class="form-group">
          <label class="control-label">Дата</label>
          <form:input cssClass="form-control dateField" path="testDate"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Описание</label>
          <form:input cssClass="form-control" path="description"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Гемоглобин</label>
          <form:input cssClass="form-control" path="hemoglobin"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Эритроциты</label>
          <form:input cssClass="form-control" path="RBCells"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Цветовой показатель</label>
          <form:input cssClass="form-control" path="colorIndex"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Ретикулоциты</label>
          <form:input cssClass="form-control" path="IMRBCells"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Тромбоциты</label>
          <form:input cssClass="form-control" path="platelets"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">СОЭ</label>
          <form:input cssClass="form-control" path="ESR"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Лейкоциты</label>
          <form:input cssClass="form-control" path="WBCells"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Палочкоядерные</label>
          <form:input cssClass="form-control" path="bandCells"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Сегментоядерные</label>
          <form:input cssClass="form-control" path="segmentCells"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Эозинофилы</label>
          <form:input cssClass="form-control" path="eosinCells"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Базофилы</label>
          <form:input cssClass="form-control" path="basophil"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Лимфоциты</label>
          <form:input cssClass="form-control" path="NKCells"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Моноциты</label>
          <form:input cssClass="form-control" path="monoCells"/>
        </div>
      </div>

      <div class="row">
        <button type="submit" class="btn btn-primary">Сохранить анализы</button>
      </div>
    </form:form>
  </fieldset>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.1.4.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap-datepicker/datepicker/js/bootstrap-datepicker.js"/>"></script>
<script type="text/javascript">
  $(document).ready(function(){
    $(".dateField").datepicker({
      format : "dd.mm.yyyy",
      autoclose: true,
      locale: 'ru'
    });
  });
</script>
</body>
</html>
