<%@ page import = "java.util.*, entity.book.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">

    <title>책 검색 페이지</title>
    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">도서 목록</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form action="booklist" method="post" class="navbar-form navbar-right input-group">
            <input type="text" name="keyword" class="form-control" placeholder="Search...">
            <input type="submit" class="form-control" value="검색">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">도서입력 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">도서수정</a></li>
            <li><a href="#">도서삭제</a></li>
            <li><a href="#">도서검색</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">도서목록</h2>
          <form method="post" action="addCart">
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
               	  <th>선택</th>
                  <th>책 이미지</th>
                  <th>책 제목</th>
                  <th>책 저자</th>
                  <th>ISBN</th>
                  <th>가격</th>
                </tr>
              </thead>
              <%
              	ArrayList<BookEntity> list = (ArrayList<BookEntity>)request.getAttribute("list");
              %>
              <tbody>
              
              <%
              	for (BookEntity e : list) {
              %>
              	<tr>
              		<td><input type="checkbox" name="check" value="<%= e.getBisbn()%>"></td>
              		<td><img src="<%= e.getBimgurl()%>"></td>
              		<td><%= e.getBtitle()%></td>
              		<td><%= e.getBauthor()%></td>
              		<td><%= e.getBisbn()%></td>
              		<td><%= e.getBprice()%></td>
              	</tr>
              <%
              	}
              %>
              </tbody>
            </table>
          </div>
          <button type="submit">장바구니에 담기</button>
          </form>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  </body>
</html>
    