import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie.model';
import { LandingPageService } from 'src/app/services/landing-page.service';

@Component({
  selector: 'app-premieres',
  templateUrl: './premieres.component.html',
  styleUrls: ['./premieres.component.css']
})
export class PremieresComponent implements OnInit {
  peliculas : Movie[] = []
  constructor(public _landingService:LandingPageService) { }

  ngOnInit() {
    this.getPremieres()
  }

  getPremieres(){
    this._landingService.getMovies().subscribe((movies)=>{
      this.peliculas = movies.filter(mov=>!mov.cartelera)
    })
  }

}
