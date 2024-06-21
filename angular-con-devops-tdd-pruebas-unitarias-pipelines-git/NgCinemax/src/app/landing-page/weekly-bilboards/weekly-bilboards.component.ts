import { Component, OnInit } from '@angular/core';
import { LandingPageService } from 'src/app/services/landing-page.service';
import { Movie } from 'src/app/models/movie.model';

@Component({
  selector: 'app-weekly-bilboards',
  templateUrl: './weekly-bilboards.component.html',
  styleUrls: ['./weekly-bilboards.component.css']
})
export class WeeklyBilboardsComponent implements OnInit {
  peliculas : Movie[] = []
  constructor(public _landingService:LandingPageService) { }

  ngOnInit() {
    this.getWeeklyBilboards()
  }

  getWeeklyBilboards(){
    this._landingService.getMovies().subscribe((movies)=>{
      this.peliculas = movies.filter(mov=>mov.cartelera)
    })
  }

}
