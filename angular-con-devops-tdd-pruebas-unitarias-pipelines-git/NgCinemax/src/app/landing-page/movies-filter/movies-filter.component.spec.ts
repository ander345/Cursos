import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviesFilterComponent } from './movies-filter.component';
import { FormsModule } from '@angular/forms';
import { LandingPageService } from 'src/app/services/landing-page.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Movie } from 'src/app/models/movie.model';
import { of } from 'rxjs'
describe('MoviesFilterComponent', () => {
  let component: MoviesFilterComponent;
  let fixture: ComponentFixture<MoviesFilterComponent>;
  let service : LandingPageService

  let mockResponsePeliculas : Movie[] = [
    {
    "cartelera": true,
    "descripcion": "Superman (Henry Cavill) se ha convertido en la figura más controvertida del mundo. Mientras que muchos siguen creyendo que es un emblema de esperanza, otro gran número de personas lo consideran una amenaza para la humanidad. Para el influyente Bruce Wayne (Ben Affleck), Superman es claramente un peligro para la sociedad, su poder resulta imprudente y alejado de la mano del gobierno. Por eso, ante el temor de las acciones que pueda llevar a cabo un superhéroe con unos poderes casi divinos, decide ponerse la máscara y la capa para poner a raya al superhéroe de Metrópolis. Mientras que la opinión pública debate sobre el interrogante de cuál es realmente el héroe que necesitan, el Hombre de Acero y Batman, enfrentados entre sí, se sumergen en una contienda el uno contra el otro. La rivalidad entre ellos está alimentada por el rencor y la venganza, y nada puede disuadirlos de librar esta guerra. Hostigados por el multimillonario Lex Luthor (Jesse Eisenberg), Batman y Superman se ven las caras en una lucha sin precedentes. Pero las cosas se complican cuando una nueva y peligrosa amenaza pronto cobra fuerza, poniendo a toda la humanidad en el mayor peligro que nunca se haya conocido antes. Esta nueva y oscura amenaza, que surge con la figura de un tercer hombre con poderes superlativos llamado Doomsday, puede poner en serio peligro al mundo y causar la destrucción total. Será entonces cuando el Último Hijo de Krypton y el Caballero Oscuro unan sus fuerzas con Wonder Woman (Gal Gadot) para enfrentarse todos juntos a esta amenazante nueva máquina de matar.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/BatmanVSSuperman.jpg?alt=media&token=2cde782d-40cf-4088-8d2f-3ec9eb3091c1",
    "likes": 54,
    "nombre": "Batman vs Superman",
    "trailer": "https://www.youtube.com/watch?v=0WWzgGyAH6Y"
    },
    {
    "cartelera": true,
    "descripcion": "En un futuro no muy lejano, legiones de gigantescas criaturas monstruosas comienzan a salir misteriosamente de las profundidades del mar con el objetivo de iniciar una guerra contra la humanidad que puede destruir millones de vidas y agotar todos los recursos que el ser humano necesita para sobrevivir. Estas terribles criaturas, hasta entonces desconocidas por la raza humana, son denominadas Kaiju, nombre que hace referencia a las películas sobre grandes y espeluznantes criaturas propias del género cinematográfico japonés que comparte el mismo nombre.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/pacific-rim.jpg?alt=media&token=0e01c004-89a1-4473-bd9d-7c4bfac26987",
    "likes": 36,
    "nombre": "Pacific Rim 2013",
    "trailer": "https://www.youtube.com/watch?v=K-ZcqwvQbas"
    },
    {
    "cartelera": true,
    "descripcion": "Arizona, 1873. Un extraño (Craig), que no recuerda su pasado, acaba por casualidad en el duro y desértico pueblo de Absolution. La única pista sobre esta misteriosa historia es un grillete que lleva enganchado en su muñeca. Pronto descubre que los forasteros no son bienvenidos en Absolution y que nadie mueve un dedo en sus calles sin que se lo ordene el Coronel (mano de hierro) Dolarhyde Ford. Es un pueblo que vive sumido en el miedo. Pero Absolution está a punto de experimentar un pánico incompresible cuando la desolada ciudad es atacada por unos maleantes desde el cielo. Haciendo un gran ruido y a una impresionante velocidad, las luces cegadoras abducen a los indefensos uno a uno, desafiando todo lo que los residentes conocían hasta ahora.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/cowboys_aliens.jpg?alt=media&token=500f5244-6f07-4d46-8d08-35d59d2c2fb7",
    "likes": 61,
    "nombre": "Cowboys & Aliens",
    "trailer": "https://www.youtube.com/watch?v=MqCp2PmRyXg"
    },
    {
    "cartelera": true,
    "descripcion": "Una historia alrededor de la población vasca bombardeada por la aviación nazi en abril de 1937, durante la Guerra Civil Española. En ese contexto, la joven Teresa (María Valverde), una editora de la oficina de prensa republicana chocará con Henry (James D’Arcy), un periodista americano en horas bajas que está cubriendo el conflicto. Teresa, cortejada por su jefe, Vasyl (Jack Davenport), asesor soviético del gobierno republicano, se sentirá atraída por el idealismo durmiente de Henry y querrá despertar en él la pasión por contar la verdad, que un día fue su único objetivo.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/gernika.jpg?alt=media&token=f88301fd-c195-4d9f-a9b9-b68659c5a77f",
    "likes": 12,
    "nombre": "Gernika",
    "trailer": "https://www.youtube.com/watch?v=uuKl2dIiUzM"
    },
    {
    "cartelera": true,
    "descripcion": "El temerario aventurero Peter Quill es objeto de un implacable cazarrecompensas después de robar una misteriosa esfera codiciada por Ronan, un poderoso villano cuya ambición amenaza todo el universo. Para poder escapar del incansable Ronan, Quill se ve obligado a pactar una complicada tregua con un cuarteto de disparatados inadaptados: Rocket, un mapache armado con un rifle, Groot, un humanoide con forma de árbol, la letal y enigmática Gamora y el vengativo Drax the Destroyer. Pero cuando Quill descubre el verdadero poder de la esfera, deberá hacer todo lo posible para derrotar a sus extravagantes rivales en un intento desesperado de salvar el destino de la galaxia.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/guardians-galaxy.jpg?alt=media&token=dece22be-f5a6-48a3-ab13-1669dd2aa87c",
    "likes": 98,
    "nombre": "Guardianes de la Galaxia",
    "trailer": "https://www.youtube.com/watch?v=qdIuXCfUKM8"
    },
    {
    "cartelera": true,
    "descripcion": "Cuando un meteorito lleno de mugre espacial transforma a Susan Murphy en una gigante, el Gobierno le concede el nombre de Ginormica y la encierra en una instalación secreta con otros monstruos, como el Dr. Cucaracha, cabeza de insecto. Cuando un robot extraterrestre llega a la Tierra y empieza una masacre, el general W.R. Monger convence al presidente para que envíe a Ginormica y a los monstruos a enfrentarse a la máquina y salvar al planeta.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/mostruos_vs_alienigenas.jpg?alt=media&token=4840892d-7cb4-41f2-a1e3-0922db10cfa0",
    "likes": 33,
    "nombre": "Monstruos vs Alienígenas",
    "trailer": "https://www.youtube.com/watch?v=UzZRJTeMb0E"
    },
    {
    "cartelera": false,
    "descripcion": "El Imperio Galáctico ha terminado de construir el arma más poderosa de todas, la Estrella de la muerte, pero un grupo de rebeldes decide realizar una misión de muy alto riesgo: robar los planos de dicha estación antes de que entre en operaciones, mientras se enfrentan también al poderoso Lord Sith conocido como Darth Vader, discípulo del despiadado Emperador Palpatine. Film ambientado entre los episodios III y IV de Star Wars.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/RogueOneP.jpg?alt=media&token=2e40855e-30f0-4465-8901-e91601d399a1",
    "likes": 0,
    "nombre": "Rogue One",
    "trailer": "https://www.youtube.com/watch?v=frdj1zb9sMY"
    },
    {
    "cartelera": false,
    "descripcion": "Dos adolescentes pacientes de cáncer inician un viaje para reafirmar sus vidas y visitar a un escritor solitario en Ámsterdam.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/stars.jpg?alt=media&token=8e12c3ef-e3a7-445b-b8a1-2c5d0bcb4f0b",
    "likes": 0,
    "nombre": "Bajo la misma Estrella",
    "trailer": "https://www.youtube.com/watch?v=9Lt8QAZkc94"
    },
    {
    "cartelera": false,
    "descripcion": "Ahmanet, una antigua princesa egipcia maldita, despierta en su cripta y, furiosa y malvada, siembra el terror entre los humanos. La única persona que puede detenerla y evitar que arrase Londres es un intrépido mercenario.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/the_mummy.jpg?alt=media&token=87e4bcdb-287a-46e2-b2ed-9a1ed3546a75",
    "likes": 0,
    "nombre": "La Momia",
    "trailer": "https://www.youtube.com/watch?v=b6iqUM7bxk4"
    },
    {
    "cartelera": false,
    "descripcion": "El periodista Eddie Brock está investigando a Carlton Drake, el célebre fundador de Life Foundation. Brock establece una simbiosis con un ente alienígena que le ofrece superpoderes, pero el ser se apodera de su personalidad y le vuelve perverso.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/venom.jpg?alt=media&token=f9636481-e034-44f3-9bb9-3f18f148cb0b",
    "likes": 0,
    "nombre": "Venom",
    "trailer": "https://www.youtube.com/watch?v=mYTmQWZkw10"
    },
    {
    "cartelera": false,
    "descripcion": "Un desertor de la escuela de medicina intenta ocultar su atracción hacia su nueva amiga (Zoe Kazan), una brillante artista que ya tiene novio.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/what_if.jpg?alt=media&token=7665cec3-daf7-40c6-9ccf-18378f125de5",
    "likes": 0,
    "nombre": "¿Sólo amigos?",
    "trailer": "https://www.youtube.com/watch?v=-CuAGFDpVpU"
    },
    {
    "cartelera": false,
    "descripcion": "Diana, hija de dioses y princesa de las amazonas, nunca ha salido de su isla. Un día, en el contexto de la Primera Guerra Mundial, un piloto americano se estrella en su isla y Diana salva su vida; el piloto le explica que se está desarrollando una gran guerra que puede devastar el mundo, y Diana parte a la batalla.",
    "idioma": "Español",
    "imagen": "https://firebasestorage.googleapis.com/v0/b/cinemax-ded91.appspot.com/o/wonder_woman.jpg?alt=media&token=1d52d07b-bb31-4e49-8c7c-3f1e27ae88a9",
    "likes": 0,
    "nombre": "La mujer maravilla",
    "trailer": "https://www.youtube.com/watch?v=DYhqqzo2xOI"
    }
    ]


  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoviesFilterComponent ],
      imports : [FormsModule, HttpClientTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoviesFilterComponent);
    component = fixture.componentInstance;
    service = component._landingS
    fixture.detectChanges();
  });

  it('Debe crear el componente', () => {
    expect(component).toBeTruthy();
  });

  it('Debe inyectar el servicio LandingPageService', ()=>{
    expect(service).toBeTruthy()
  })

  it('Debe generar los 8 items de fecha requeridos', ()=>{
    component.ngOnInit()

    for (let i=0; i<=7; i++){
      let date: Date = new Date()
      date.setDate(date.getDate()+i)

      expect(component.fechas[i].toDateString()).toEqual(date.toDateString())
    }
  })

  it('Debe llamar getMovies() de _landingS', async(()=>{
    let obtenerPeliculas = spyOn(service, 'getMovies').and.returnValue(of(mockResponsePeliculas))
    

    component.ngOnInit()

    expect(obtenerPeliculas).toHaveBeenCalled()
    
    for (let i=0; i<component.peliculas.length; i++){
      expect(component.peliculas[i].cartelera).toBeTruthy()
    }
  }))

});
