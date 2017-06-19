import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Http, Response, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

    constructor(private http: Http) { };

    private baseUrl: string = "http://localhost:8080"; //To access the Spring API.
    public submitted: boolean;
    roomsearch: FormGroup;
    rooms: Room[];
    currentCheckInVal: string;
    currentCheckOutVal: string;
    request: ReserveRoomRequest;

    ngOnInit() {
        this.roomsearch = new FormGroup({
            checkin: new FormControl(''),
            checkout: new FormControl('')
        });

        const roomsearchValueChanges$ = this.roomsearch.valueChanges;

        //Tracking value changes in the form and performing updates consequently.
        roomsearchValueChanges$.subscribe(valChange => {
            this.currentCheckInVal = valChange.checkin;
            this.currentCheckOutVal = valChange.checkout;

        }
        )

        //this.rooms = ROOMS;
    }

    onSubmit({value, valid}: { value: Roomsearch, valid: boolean }) {
        this.getAll().subscribe(    //Subscribe to the async. data stream.
            //Lambdas.
            rooms => this.rooms = rooms, //Take streaming data (in JSON) and put it in an array.
            err => {    //Handling errors.
                console.log(err);
            }
        );
    }

    reserveRoom(value: string) {
        this.request = new ReserveRoomRequest(value, this.currentCheckInVal, this.currentCheckOutVal);
    }

    createReservation(body: ReserveRoomRequest) {
        let bodyString = JSON.stringify(body);
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let option = new RequestOptions({ headers: headers });

        this.http.post(this.baseUrl + '/room/reservation/v1', body, option)
            .subscribe(res => console.log(res));
    }

    getAll(): Observable<Room[]> {
        return this.http.get(
            this.baseUrl + '/room/reservation/v1?checkin=' + this.currentCheckInVal + '&checkout=' + this.currentCheckInVal)
            .map(this.mapRoom); //Returbs object from response.

    }

    mapRoom(response: Response): Room[] {
        return response.json().content;
    }
}

export interface Roomsearch {
    checkin: string;
    checkout: string;
}

export interface Room {
    id: string;
    roomNumber: string;
    price: string;
    links: string; roomId: string;
    checkin: string;
    checkout: string;
}

/*var ROOMS: Room[] = [
    {
        "id": "37489234327",
        "roomNumber": "406",
        "price": "25",
        "links": ""
    },
    {
        "id": "84329874798",
        "roomNumber": "407",
        "price": "20",
        "links": ""
    },
    {
        "id": "17238423787",
        "roomNumber": "408",
        "price": "22",
        "links": ""
    }
];*/

export class ReserveRoomRequest {
    roomId: string;
    checkin: string;
    checkout: string;

    constructor(
        roomId: string,
        checkin: string,
        checkout: string
    ) {
        this.roomId = roomId;
        this.checkin = checkin;
        this.checkout = checkout;
    };
}
