
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Book Browser</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
        .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
        .fa-anchor,.fa-coffee {font-size:200px}
    </style>
</head>
<body>

<!-- Header -->
<header class="w3-container w3-teal w3-center" style="padding:50px 16px">
    <h2 class="w3-margin w3-jumbo">Book Browser</h2>
</header>

<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
    <div class="w3-content">
        <div class="w3-twothird">

            <form class="w3-padding-32" method="GET" action="/java112/books">

                <h5><label for="title">Enter a book title:</label></h5>
                <input type="text" name="title" required>

                <input type="submit" name="submit" value="Search" class="w3-button w3-black w3-padding-large w3-large w3-margin-top">
            </form>

        </div>
        <div class="w3-third w3-center">
            <i class="fa fa-anchor w3-padding-64 w3-text-teal"></i>
        </div>
    </div>
</div>

<!-- Second Grid -->
<div class="w3-row-padding w3-light-grey w3-padding-64 w3-container">
    <div class="w3-content">
        <div class="w3-third w3-center">
            <i class="fa fa-coffee w3-padding-64 w3-text-teal w3-margin-right"></i>
        </div>

        <div class="w3-twothird">
            <h1>Team Hopper</h1>
            <h5 class="w3-padding-32">Members</h5>

            <p class="w3-text-grey"><li>Mike Turchanov</li><li>Rob Adams</li><li>Sydney St. Clair</li><li>Walker Hurd</li></p>
        </div>
    </div>
</div>

<div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
    <h1 class="w3-margin w3-xlarge">Quote of the day: live life</h1>
</div>

<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-opacity">
    <div class="w3-xlarge w3-padding-32">
        <i class="fa fa-facebook-official w3-hover-opacity"></i>
        <i class="fa fa-instagram w3-hover-opacity"></i>
        <i class="fa fa-snapchat w3-hover-opacity"></i>
        <i class="fa fa-pinterest-p w3-hover-opacity"></i>
        <i class="fa fa-twitter w3-hover-opacity"></i>
        <i class="fa fa-linkedin w3-hover-opacity"></i>
    </div>
    <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>

</body>
</html>
