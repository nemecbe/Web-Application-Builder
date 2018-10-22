import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {

    constructor(private router: Router) { }
    title = 'ngWAB';
    public sortableList = [
        'Box 1',
        'Box 2',
        'Box 3',
        'Box 4',
        'Box 5',
        'Box 6',
        'Box 7',
        'Box 8',
        'Box 9',
        'Box 10'
    ];

    public availableBoxes = [
        'Box 1',
        'Box 2',
        'Box 3',
        'Box 4',
        'Box 5'
    ];

    public dropzone1 = [
        'Box 6'
    ];

    public dropzone2 = [
        'Box 7'
    ];

    currentBox?: string;

    trappedBoxes = ['Trapped 1', 'Trapped 2'];

    add(): void {
        this.trappedBoxes.push('New trapped');
    }

    addMovable(box: string): void {
        this.trappedBoxes.push(box);
    }

    onDragStart(event: PointerEvent): void {
        console.log('got drag start');
    }

    onDragMove(event: PointerEvent): void {
        console.log(`got drag Move ${Math.round(event.clientX)}, ${Math.round(event.clientY)}`);
    }

    onDragEnd(event: PointerEvent): void {
        console.log('got drag end');
    }

    loggingIn() {
        if (this.router.url.includes('login')) {
            return '';
        }
        return 'stuff';
    }

}
