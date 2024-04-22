import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppComponent],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

<<<<<<<< HEAD:AppFront/src/app/app.component.spec.ts
  it(`should have as title 'AppFront'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('AppFront');
========
  it(`should have the 'Font' title`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('Font');
>>>>>>>> 685d440aea307017f862c6121c4a06be5ee33161:Font/src/app/app.component.spec.ts
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
<<<<<<<< HEAD:AppFront/src/app/app.component.spec.ts
    expect(compiled.querySelector('h1')?.textContent).toContain('Hello, AppFront');
========
    expect(compiled.querySelector('h1')?.textContent).toContain('Hello, Font');
>>>>>>>> 685d440aea307017f862c6121c4a06be5ee33161:Font/src/app/app.component.spec.ts
  });
});
