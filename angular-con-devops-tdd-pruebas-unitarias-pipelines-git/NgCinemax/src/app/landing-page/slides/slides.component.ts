import { Component, OnInit } from '@angular/core';
declare var $:any;
@Component({
  selector: 'app-slides',
  templateUrl: './slides.component.html',
  styleUrls: ['./slides.component.css']
})
export class SlidesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $('.slider').slider();
  }

}
