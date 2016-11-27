<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>XML parsing</title>
</head>
<body>
<h5>Choose parsing type:</h5>
<form name="parserChooserForm" action="controller" method="POST">
  <input type="hidden" name="command" value="parsing" />
  <select name="parserType">
    <option value="sax">SAX</option>
    <option value="dom">DOM</option>
    <option value="stax">StAX</option>
  </select>
  <input type="submit" name="button" value="Pars XML"/>
</form>
</body>
</html>
