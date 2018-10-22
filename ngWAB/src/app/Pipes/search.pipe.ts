import { Pipe, PipeTransform } from '@angular/core';
import { Page } from '../types/page';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(value: Page[], input?: string): Page[] {
    if (!value) {
      return [];
    }
    if (!input) {
      return value;
    }
    return value.filter(it => {
      return it.pName.includes(input);
     });
  }

}
