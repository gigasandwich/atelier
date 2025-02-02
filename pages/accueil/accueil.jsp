<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html class="loading" lang="fr" data-textdirection="ltr">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>MADA FIX</title>
    <link rel="apple-touch-icon" href="#">
    <link rel="shortcut icon" type="image/x-icon" href="../../../assets/theme-assets/images/icon.ico">
    <link href="https://fonts.googleapis.com/css?family=Muli:300,300i,400,400i,600,600i,700,700i%7CComfortaa:300,400,700" rel="stylesheet">
    <link href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome.min.css" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="../../../assets/theme-assets/css/vendors.css">
    <link rel="stylesheet" type="text/css" href="../../../assets/theme-assets/vendors/css/charts/chartist.css">
    <!-- END VENDOR CSS-->
    <!-- BEGIN CHAMELEON  CSS-->
    <link rel="stylesheet" type="text/css" href="../../../assets/theme-assets/css/app-lite.css">
    <!-- END CHAMELEON  CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="../../../assets/theme-assets/css/core/menu/menu-types/vertical-menu.css">
    <link rel="stylesheet" type="text/css" href="../../../assets/theme-assets/css/core/colors/palette-gradient.css">
    <link rel="stylesheet" type="text/css" href="../../../assets/theme-assets/css/pages/dashboard-ecommerce.css">
    <!-- END Page Level CSS-->
    <!-- BEGIN Custom CSS-->
    <!-- END Custom CSS-->
  </head>
  <body class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar" data-open="click" data-menu="vertical-menu" data-color="bg-chartbg" data-col="2-columns">

    <!-- fixed-top-->
    <nav class="header-navbar navbar-expand-md navbar navbar-with-menu navbar-without-dd-arrow fixed-top navbar-semi-light">
      <div class="navbar-wrapper">
        <div class="navbar-container content">
          <div class="collapse navbar-collapse show" id="navbar-mobile">
            <ul class="nav navbar-nav mr-auto float-left">
              <li class="nav-item d-block d-md-none"><a class="nav-link nav-menu-main menu-toggle hidden-xs" href="#"><i class="ft-menu"></i></a></li>
              <li class="nav-item d-none d-md-block"><a class="nav-link nav-link-expand" href="#"><i class="ficon ft-maximize"></i></a></li>
              <li class="nav-item dropdown navbar-search"><a class="nav-link dropdown-toggle hide" data-toggle="dropdown" href="#"><i class="ficon ft-search"></i></a>
                <ul class="dropdown-menu">
                  <li class="arrow_box">
                    <form>
                      <div class="input-group search-box">
                        <div class="position-relative has-icon-right full-width">
                          <input class="form-control" id="search" type="text" placeholder="Search here...">
                          <div class="form-control-position navbar-search-close"><i class="ft-x">   </i></div>
                        </div>
                      </div>
                    </form>
                  </li>
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav float-right">
              <li class="dropdown dropdown-language nav-item"><a class="dropdown-toggle nav-link" id="dropdown-flag" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="flag-icon flag-icon-fr"></i><span class="selected-language"></span></a>
                <div class="dropdown-menu" aria-labelledby="dropdown-flag">
                    <div class="arrow_box">
                        <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-us"></i> English</a>
                        <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-cn"></i> Chinese</a>
                        <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-ru"></i> Russian</a>
                        <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-fr"></i> French</a>
                        <a class="dropdown-item" href="#"><i class="flag-icon flag-icon-es"></i> Spanish</a>
                    </div>
                </div>
              </li>
            </ul>
            <ul class="nav navbar-nav float-right">
              <li class="dropdown dropdown-notification nav-item"><a class="nav-link nav-link-label" href="#" data-toggle="dropdown"><i class="ficon ft-mail">             </i></a>
                <div class="dropdown-menu dropdown-menu-right">
                  <div class="arrow_box_right">
                    <a class="dropdown-item" href="#"><i class="ft-book"></i> Read Mail</a>
                    <a class="dropdown-item" href="#"><i class="ft-bookmark"></i> Read Later</a>
                    <a class="dropdown-item" href="#"><i class="ft-check-square"></i> Mark all Read       </a>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>

    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <div class="main-menu menu-fixed menu-light menu-accordion    menu-shadow " data-scroll-to-active="true" data-img="theme-assets/images/backgrounds/02.jpg">
      <div class="navbar-header">
        <ul class="nav navbar-nav flex-row">       
          <li class="nav-item mr-auto"><a class="navbar-brand" href="home"><img class="brand-logo" alt="" src="theme-assets/images/logo.jpg"/>
              <h3 class="brand-text">MADA FIX</h3></a></li>
          <li class="nav-item d-md-none"><a class="nav-link close-navbar"><i class="ft-x"></i></a></li>
        </ul>
      </div>

      <div class="main-menu-content">
        <ul class="navigation navigation-main" id="main-menu-navigation" data-menu="menu-navigation">
          
          <li class="active">
            <a href="home">
              <i class="ft-home"></i>
              <span class="menu-title" data-i18n="">Dashboard</span>
            </a>
          </li>

          <li class=" nav-item has-sub">
            <a href="#">
              <i class="la la-puzzle-piece"></i>
              <span class="menu-title" data-i18n="">Composants</span>
            </a>
            <ul class="manu-content">
              <li class="has-sub">
                  <a href="#" class="menu-item">Marque</a>
                  <ul class="menu-content">
                    <li>
                      <a href="insertion-marque" class="menu-item">Insertion</a>
                    </li>
                    <li>
                      <a href="liste-marque" class="menu-item">Liste</a>
                    </li>
                  </ul>
              </li>
              <li class="has-sub">
                <a href="#" class="menu-item">Modele</a>
                <ul class="menu-content">
                  <li>
                    <a href="inserion-modele" class="menu-item">Insertion</a>
                  </li>
                  <li>
                    <a href="liste-modele" class="menu-item">Liste</a>
                  </li>
                </ul>
              </li>
              <li class="has-sub">
                <a href="#" class="menu-item">Processeur</a>
                <ul class="menu-content">
                  <li>
                    <a href="insertion-processeur" class="menu-item">Insertion</a>
                  </li>
                  <li>
                    <a href="liste-processeur" class="menu-item">Liste</a>
                  </li>
                </ul>
              </li>
              <li class="has-sub">
                <a href="#" class="menu-item">RAM</a>
                <ul class="menu-content">
                  <li>
                    <a href="insertion-ram" class="menu-item">Insertion</a>
                  </li>
                  <li>
                    <a href="liste-ram" class="menu-item">Liste</a>
                  </li>
                </ul>
              </li>
              <li class="has-sub">
                <a href="#" class="menu-item">Stocakge</a>
                <ul class="menu-content">
                  <li>
                    <a href="insertion-stockage" class="menu-item">Insertion</a>
                  </li>
                  <li>
                    <a href="liste-stockage" class="menu-item">Liste</a>
                  </li>
                </ul>
              </li>
              <li class="has-sub">
                <a href="#" class="menu-item">Type Ordinateur</a>
                <ul class="menu-content">
                  <li>
                    <a href="insertion-type-ordinateur" class="menu-item">Insertion</a>
                  </li>
                  <li>
                    <a href="liste-type-ordinateur" class="menu-item">Liste</a>
                  </li>
                </ul>
              </li>
            </ul>
          </li>

          <li class=" nav-item has-sub">
            <a href="#">
                <i class="ft-layout"></i>
                <span class="menu-title" data-i18n="">Ordinateur</span>
            </a>
            <ul class="manu-content">
                <li>
                    <a href="insertion-ordinateur" class="menu-item">Insertion</a>
                </li>
                <li>
                  <a href="recherche-ordinateur" class="menu-item">Recherche</a>
              </li>
            </ul>
          </li>
          
          <li class=" nav-item has-sub">
            <a href="#">
                <i class="ft-layout"></i>
                <span class="menu-title" data-i18n="">Client</span>
            </a>
            <ul class="manu-content">
                <li>
                    <a href="insertion-client" class="menu-item">Insertion</a>
                </li>
                <li>
                  <a href="liste-client" class="menu-item">Liste</a>
              </li>
            </ul>
          </li>

          <li class=" nav-item has-sub">
            <a href="#">
                <i class="ft-layout"></i>
                <span class="menu-title" data-i18n="">Probleme</span>
            </a>
            <ul class="manu-content">
                <li>
                    <a href="insertion-probleme" class="menu-item">Insertion</a>
                </li>
                <li>
                  <a href="liste-probleme" class="menu-item">Liste</a>
              </li>
            </ul>
          </li>

          <li class=" nav-item has-sub">
            <a href="#">
                <i class="ft-layout"></i>
                <span class="menu-title" data-i18n="">Reparation</span>
            </a>
            <ul class="manu-content">
                <li>
                    <a href="insertion-reparation" class="menu-item">Insertion</a>
                </li>
                <li>
                  <a href="recherche-reparation" class="menu-item">Recherche</a>
              </li>
            </ul>
          </li>

          <li class=" nav-item has-sub">
            <a href="#">
                <i class="ft-layout"></i>
                <span class="menu-title" data-i18n="">Technicien</span>
            </a>
            <ul class="manu-content">
                <li>
                    <a href="insertion-technicien" class="menu-item">Insertion</a>
                </li>
                <li>
                  <a href="liste-technicien" class="menu-item">Liste</a>
              </li>
            </ul>
          </li>
      
        </ul>
      </div>
      
      <div class="navigation-background"></div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <div class="app-content content">
      <div class="content-wrapper">
          <jsp:include page="${pageName}" />
      </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->


    <footer class="footer footer-static footer-light navbar-border navbar-shadow">
      <div class="clearfix blue-grey lighten-2 text-sm-center mb-0 px-2"><span class="float-md-left d-block d-md-inline-block">2025 &copy; Copyright <a class="text-bold-800 grey darken-2" href="#" target="_blank">Projet reparation d' ordinateur</a></span>
      </div>
    </footer>

    <!-- BEGIN VENDOR JS-->
    <script src="../../../assets/theme-assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="../../../assets/theme-assets/vendors/js/charts/chartist.min.js" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN CHAMELEON  JS-->
    <script src="../../../assets/theme-assets/js/core/app-menu-lite.js" type="text/javascript"></script>
    <script src="../../../assets/theme-assets/js/core/app-lite.js" type="text/javascript"></script>
    <!-- END CHAMELEON  JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="../../../assets/theme-assets/js/scripts/pages/dashboard-lite.js" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
  </body>
</html>