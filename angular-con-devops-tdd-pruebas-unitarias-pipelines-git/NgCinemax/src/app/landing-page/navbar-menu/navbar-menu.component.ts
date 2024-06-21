import { Component, OnInit } from '@angular/core';
declare var $:any;
@Component({
  selector: 'app-navbar-menu',
  templateUrl: './navbar-menu.component.html',
  styleUrls: ['./navbar-menu.component.css']
})
export class NavbarMenuComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $(".dropdown-trigger").dropdown();
    $('.sidenav').sidenav();
  }

}
