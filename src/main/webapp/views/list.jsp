<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gis.booking.app.entities.Place"%>
<%@page import="java.sql.ResultSet"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Here List!</title>
    </head>
    <body>
        <h1>Список мест</h1>
    </body>
    
    <div>
        
        <%!
            public String check(boolean check)
            {
            if (check)
                return "забронировано"; 
            else 
                return "свободно";
            }
            
        %>
        <%
        ResultSet rs=(ResultSet) request.getAttribute("rs");
        int i=1;
        if (rs!=null)
        {
            %><table>
                <thead>
                    <tr>
                        <th><%out.println("место:");%></th>
                        <th><%out.println(i++);%></th>
                        <th><%out.println(i++);%></th>
                        <th><%out.println(i++);%></th>
                        <th><%out.println(i++);%></th>
                        <th><%out.println(i++);%></th>
                        <th><%out.println(i++);%></th>
                    </tr>
                </thead><%
                        
                while (rs.next())
                {
                    %><tbody>
                        <tr align="center">
                            <td><%out.println("ряд "+ rs.getString(2)+":");%></td>        
                            <td><%out.println(check(rs.getBoolean(3)));%></td>
                            <td><%out.println(check(rs.getBoolean(4)));%></td>
                            <td><%out.println(check(rs.getBoolean(5)));%></td>
                            <td><%out.println(check(rs.getBoolean(6)));%></td>
                            <td><%out.println(check(rs.getBoolean(7)));%></td>
                            <td><%out.println(check(rs.getBoolean(8)));%></td>
                        </tr>
                    </tbody><%
                }
            %></table> <%
        }
            





            %>
        </div> 

        <h2> Введите данные</h2>
        <div>
            <form method="post">
                <label>Кинотеатр:
                    <input type="text" name="cinema"><br />
                </label>
                
                <label>Зал:
                    <input type="text" name="hall"><br />
                </label>
                             
                <button type="submit">Получить список</button>
            </form>
        </div>
       
        <div>
            <button onclick="location.href='/'">Вернуться в главное меню</button>
        </div>

</html>
