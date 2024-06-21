import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SocialNetwork } from '../landing-page/navbar-social/social-network';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Movie } from '../models/movie.model';

@Injectable({
  providedIn: 'root'
})
export class LandingPageService {

  apiRedes:string = 'RedesSociales.json'
  apiPeliculas: string = 'Peliculas.json'

  formatos: string [] = [
    'Doblada 2D', 'Doblada 3D', 'Idioma Original 2D', 'Idioma Original 3D'
  ]

  horas : string [] = []
  constructor(public _http : HttpClient) { 

    this.generateHours()
  }  

  generateHours(){
    for (let i = 2; i<=10; i = i+2){
      let hora = `${i}:00pm`
      this.horas.push(hora)
    }
  }

  getSocialNetworks():Observable<SocialNetwork[]>{
    return this._http.get<SocialNetwork[]>(`${environment.API}${this.apiRedes}`)
  }

  getMovies():Observable<Movie[]>{
    return this._http.get<Movie[]>(`${environment.API}${this.apiPeliculas}`)
  }
}
