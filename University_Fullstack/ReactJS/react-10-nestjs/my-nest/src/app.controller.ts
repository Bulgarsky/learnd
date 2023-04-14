import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';
import {product} from "./product";

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getHello() {
    return{product};
  }
}
