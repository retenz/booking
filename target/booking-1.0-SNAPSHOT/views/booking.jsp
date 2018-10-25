<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Here booking</title>
    </head>
    <body>
        <h1>Бронирование</h1>
        
        <div>
            <%
                String cinema= (String) request.getAttribute("cinema");
                String hall= (String) request.getAttribute("hall");
                String row= (String) request.getAttribute("row");
                String sit= (String) request.getAttribute("sit");
                String check = (String) request.getAttribute("check");
                
                if(cinema!=null && hall!=null && row!=null && sit!=null)
                {
                    
                    %>
                    <table>
                        
                            <tr><br><%out.println("кинотеатр: "+cinema);%></tr>        
                            <tr><br><%out.println("зал: "+ hall);%></tr>
                            <tr><br><%out.println("ряд: "+ row);%></tr>
                            <tr><br><%out.println("мксто: "+ sit);%></tr>
                            <tr><br><%out.println("бронь: " +check);}%></tr>
                        
                    </table>
        </div> 

        <h2> Введите данные </h2>
        <div>
            <form method="post">
                <label>Кинотеатр:
                    <input type="text" name="cinema"><br />
                </label>
                
                <label>Зал:
                    <input type="text" name="hall"><br />
                </label>
                
                <label>Ряд:
                    <input type="text" name="row"><br />
                </label>
                
                <label>Место:
                    <input type="text" name="sit"><br />
                </label>
                <button type="submit">Забронировать</button>
            </form>
        </div>
       
        <div>
            <button onclick="location.href='/'">Вернуться в главное меню</button>
        </div>

</html>
