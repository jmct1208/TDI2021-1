import { Component, OnInit } from '@angular/core';

import { Persona } from '../../_models/persona';
import { PersonaService } from '../../_services/persona.service';

import { Tweet } from '../../_models/tweet';
import { TweetService } from '../../_services/tweet.service';

import { FormBuilder, Validators, FormGroup } from '@angular/forms';

declare var $: any;

@Component({
  selector: 'app-tweet',
  templateUrl: './tweet.component.html',
  styleUrls: ['./tweet.component.css']
})
export class TweetComponent implements OnInit {

  tweets: Tweet[];
  tweetForm: FormGroup;
  imagen: File;
  submitted = false;

  personas: Persona[] | any;
  personaSeleccionada: number;

  constructor(private personaService: PersonaService, private tweetService: TweetService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    //Iniciar el formulario vacio
    this.tweetForm = this.formBuilder.group({
      id: [''],
      id_persona: [''],
      descripcion: ['', Validators.required],
      imagen: [''],
      estatus: ['']
    });

    //Consultar lista de personas
    this.getPersonas();
    this.personaSeleccionada=0;
  }

  getPersonas(){
    this.personas = [];
    this.personaService.getPersonas().subscribe(
      res => {
        this.personas = res;
        console.log(this.personas)
      },
      err => console.error(err)
    )
  }

  getPersonaTweets(id: number){
    this.tweets = [];
    this.tweetService.getTweetsPersona(id).subscribe(
      res => {
        this.tweets = res;
        console.log(this.personas)
      },
      err => console.error(err)
    )
  }

  imagenSelected(event){
    this.imagen = <File> event.target.files[0];
  }

  createTweet(){
    this.submitted = true;

    if(this.tweetForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    this.tweetForm.controls['id_persona'].setValue(this.personaSeleccionada);
    this.tweetForm.controls['estatus'].setValue("activo");

    this.convertImage(this);
  }

  // Convierte imagen a base64
  convertImage(thiss): any {
    let reader = new FileReader();
    reader.readAsDataURL(thiss.imagen);
    reader.onload = function () {
      thiss.tweetForm.controls['imagen'].setValue(reader.result);
      
      thiss.tweetService.createTweet(thiss.tweetForm.value, thiss.personaSeleccionada).subscribe(
        res => {
          $("#tweetModal").modal("hide");
          thiss.getPersonaTweets(thiss.personaSeleccionada);
        },
        err => console.error(err)
      )
    };
    
    reader.onerror = function (error) {
      console.log('Error: ', error);
    };
  }


  deleteTweet(id: number, id_persona: number){
    this.tweetService.deleteTweet(id).subscribe(
      res => {
        this.getPersonaTweets(id_persona);
      },
      err => console.error(err)
    )
  }

  get f() { return this.tweetForm.controls;}

  openModalTweet(){
    this.tweetForm.reset();
    $("#tweetModal").modal("show");
  }

}
