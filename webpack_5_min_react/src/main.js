import React from 'react';
import ReactDom from "react-dom"

import AppHello from '../component/hello';

import './assets/main.css';
import "bootstrap/dist/css/bootstrap.css";

document.addEventListener("DOMContentLoaded", function (){
	new Timer(".test", 1000);
	const x= 1;
	const obj={
		a:1,
		b:2,
	}

	ReactDom.render(
		<>
			<AppHello />
			<AppHello name="John"/>
			<AppHello name="BULGARKSY"/>
		</>,
		document.querySelector(".app")
	)
	}
);

class Timer{
	constructor(selector, time) {
		this.el = document.querySelector(selector);
		this.time = time;
		this.interval = null;
		this.render();
		this.start();
	}

	tick(){
		this.time--;
		this.render();

		if (this.time <= 0) {
			this.stop();
		}
	}

	start(){
		this.interval= window.setInterval(() => this.tick(), 100);
	}

	stop(){
		window.clearInterval(this.interval);
	}

	render(){
		this.el.innerHTML = this.time;
	}
}