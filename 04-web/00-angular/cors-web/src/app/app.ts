import { HttpClient } from '@angular/common/http';
import { Component, OnInit, signal } from '@angular/core';

type Player = {
  id?: number;
  name: string;
  dob: Date;
  wage: number;
  height: number;
  shirt: number;
}

@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {

  players = signal<Player[]>([]);

  nameSearch: string = '';
  wageSearch: number | null = null;
  private apiURL = 'http://localhost:8080/players';

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.loadPlayers();
  }

  loadPlayers() {
    let url = `${this.apiURL}?`;
    if (this.nameSearch) {
      url += `name=${this.nameSearch}&`;
    }
    if (this.wageSearch) {
      url += `wage=${this.wageSearch}`;
    }

    this.http.get<Player[]>(url).subscribe(data => {
      this.players.set(data);
    })
  }

}
