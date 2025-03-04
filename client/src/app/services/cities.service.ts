import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom } from "rxjs";
import { City } from "../model/city";
import { db } from "../shared/app.db";

@Injectable({
    providedIn: 'root'
  })
export class CitiesService {
    cities: City[] = [];
    constructor(private httpClient: HttpClient){}

    getCities(){
        return lastValueFrom(this.httpClient.get<City[]>('/api/cities'));
    }

    async initCitiesToIndexDb(){
        await db.cities.clear();
        this.cities = await this.getCities();
        this.cities.forEach(async(city) => {
            await db.addCity({
                code: city.code,
                city_name: city.city_name
            });
        });
    }
}