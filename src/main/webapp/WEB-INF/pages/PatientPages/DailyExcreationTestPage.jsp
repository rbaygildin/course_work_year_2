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
<c:url var="addDailyExcreationTest" value="/addDailyExcreationTest"/>
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
    <legend>Суточная экскреция</legend>
    <form:form cssClass="form-horizontal" method="post" action="${addDailyExcreationTest}" modelAttribute="dailyExcreationTest">
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
          <label class="control-label">Креатинин</label>
          <form:input cssClass="form-control" path="creatinine"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Мочевина</label>
          <form:input cssClass="form-control" path="urea"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Мочевая кислота</label>
          <form:input cssClass="form-control" path="ureaAcid"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Кальций</label>
          <form:input cssClass="form-control" path="calcium"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Калий</label>
          <form:input cssClass="form-control" path="potassium"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Магний</label>
          <form:input cssClass="form-control" path="magnesium"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Натрий</label>
          <form:input cssClass="form-control" path="sodium"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Оксид Фосфора</label>
          <form:input cssClass="form-control" path="phosphorOxide"/>
        </div>
      </div>
      <div class="row">
        <div class="form-group">
          <label class="control-label">Хлор</label>
          <form:input cssClass="form-control" path="chlorine"/>
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

