import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { BiciparkingService } from './service/biciparking.service'


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  biciparkingForm: FormGroup;
  registros: any;

  constructor(
    public fb: FormBuilder,
    public biciparkingService: BiciparkingService
  )
  {
  }

  ngOnInit(): void {
    this.biciparkingForm = this.fb.group({
      idRegistroBicicleta: [''],
      nombre: ['', Validators.required],
      serialBici: ['', Validators.required],
      identificacion: ['', Validators.required],
      fechaSalida: [''],
      fechaIngreso: ['']
    });

    this.biciparkingService.getAllBiciparking().subscribe(resp => {
      this.registros = resp;
    },
      error => { console.error(error) }
    );
  }

  guardar(): void {
    this.biciparkingService.saveBiciparking(this.biciparkingForm.value).subscribe(resp => {
      console.log(resp);
      console.log("Form Submitted!");
      this.biciparkingForm.reset();
      this.ngOnInit();
    },
      error => { console.error(error) }
    )
  }

  registrarSalida(id: number){
    this.biciparkingService.registrarSalida(id).subscribe(resp=>{
      this.registros.push(resp);
      this.ngOnInit();
    })
  }

  eliminar(id: number){
    this.biciparkingService.eliminarRegistro(id).subscribe(resp=>{
      this.registros.push(resp);
      this.ngOnInit();
    })
  }
}
