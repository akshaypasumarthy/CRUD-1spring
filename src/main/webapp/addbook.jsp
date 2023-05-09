<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title></title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="" />
    <style>
      body {
        margin: 0;
        padding: 0;
        min-height: 100%;
        display: flex;
        flex-direction: column;
      }

      header {
        background-color: #333;
        color: #fff;
        display: flex;
        justify-content: space-between;
        padding: 1rem;
      }

      header p {
        font-size: 1.2rem;
        margin: 0;
      }

      header form {
        margin: 0;
        display: flex;
        align-items: center;
      }

      header input[type="submit"] {
        background-color: #fff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 1rem;
        padding: 0.5rem;
        margin-left: 1rem;
      }

      header div {
        display: flex;
        align-items: center;
      }

      main {
        padding: 1rem;
        flex: 1;
      }

      main h2 {
        font-size: 2rem;
        margin-top: 0;
        display: inline-block;
      }

      main form {
        
        margin-left: 1rem;
      }
      main form input[type="text"],
      main form input[type="date"] {
        margin-bottom: 1rem;
      }

      main input[type="submit"],
      main input[type="reset"] {
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 1rem;
        padding: 0.5rem;
        margin-right: 1rem;
      }

      footer {
        background-color: #333;
        color: #fff;
        padding: 1rem;
        margin-top: auto;
        position: fixed;
        bottom: 0;
        left: 0;
        right: 0;
        text-align: center;
      }

      footer p {
        margin: 0;
      }

      .head1 {
        margin-left: 87%;
      }

      .h2 {
        margin-left: 4%;
        margin-right: 39%;
      }
   
    </style>
    
  </head>
  <body>
    <header>
      <div class="head1">
        <p>Welcome User</p>
        <form action="Logout">
          <input type="submit" value="logout" />
        </form>
      </div>
    </header>
    <main>
      <div>
        <h2 class="h2">
        ADD Book Details
        </h2>
        <form action="Insertbook" method="POST">
            Book Code:<input type="number" placeholder="bookcode" name="bookcode" id="bookcode">
            <br><br>
            Book Name:<input type="text" placeholder="Bookname" name="bookname" id="bookname">
            <br><br>
            Author:<input type="text" placeholder="Author" name="author" id="author">
            <br><br>
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" value="" id="date">
        
            <br><br>
          <input type="submit" value="submit" />
          <input type="reset" value="cancel"> 
        </form>
        <script> 
            var today = new Date();
               var dd = today.getDate();
               var mm = today.getMonth()+1; //January is 0!
               var yyyy = today.getFullYear();
               if(dd<10){
                   dd='0'+dd
               } 
               if(mm<10){
                   mm='0'+mm
               } 
               today = yyyy+'-'+mm+'-'+dd;
               document.getElementById("date").value = today;
            </script>
      </div>
    </main>
    <footer>
      <div>
        <p>Nagarro Training</p>
      </div>
    </footer>
  </body>
</html>
