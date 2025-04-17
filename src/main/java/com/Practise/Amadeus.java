package com.Practise;

public class Amadeus {

    public static void main(String[] args) {

        /*
                    *
            console.log("Hello World!")

             ^10.0.0

            minor + patch
            Default; balances stability + flexibility

            // ~

            patch only
            Use when you want very stable deps


                "@angular/core": "^10.0.0",
                "@angular/forms": "^10.0.0",


            "rxjs": "~7.8.0",

           // what is ts.config.json used for
           *
           * tsconfig.json file is a configuration file for TypeScript,
           * and it’s
           * essential in Angular and any TypeScript-based project.
           *
           * {
  "compilerOptions": {
    "target": "es2020",
    "module": "esnext",
    "strict": true,
    "outDir": "./dist",
    "baseUrl": "./",
    "paths": {
      "@app/*": ["src/app/*"]
    }
  },
  //  "include": ["src/.ts"],*/
  //   "exclude": ["node_modules", "dist"]
  //  }
//**************************************************************

            //what purpose angular.json used for
            /* angular uses multiple ts config.json
            tsconfig.json        Base config (shared across all environments)
            tsconfig.app.json    For your application code
            tsconfig.spec.json   For unit tests
            tsconfig.server.json For Angular Universal (SSR apps)

	Controls compilation behavior
	•	Enables type safety
	•	Speeds up development with intelligent autocompletion
	•	Powers Angular CLI builds, tests, linting, etc.

//**************************************************************

            * //pur impure pipe
          Pure Pipe
	•	Called only if inputs change.
	•	Skips unnecessary recalculations.

Impure Pipe
	•	Called on every change detection cycle, regardless of input change.
	•	Always re-executes.

	<p>{{ counter | myImpurePipe }}</p>
	setInterval(() => this.counter++, 1000);
		•	Every 1 second, counter changes → triggers change detection.
	•	myImpurePipe is called every second — even if it doesn’t need to be.
	•	If the pipe were pure, it would only re-run when counter changes.

But let’s say something else in the app changed — like a click
in a different component — Angular may still run change detection
across the app, and the impure pipe runs again even if counter didn’t
change.

Pure Pipe
Impure Pipe
Efficient
Can slow down performance
Skips unchanged inputs
Runs on every single DOM update
Ideal for formatting
Use carefully with mutable data

If you’re using impure pipes, they’ll execute every time — even if their inputs are the same — which can slow down large apps.
             */




             /*write cusotm pipe to take value 10 and write
             10.000
            <p> {{value | myCustomPipe}} </p>


            10 -> 10.000

            import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'myCustomPipe'
})
export class MyCustomPipe implements PipeTransform {
  transform(value: number): string {
    return value.toFixed(3); // Converts 10 => "10.000"
  }
}

import { MyCustomPipe } from './my-custom.pipe';

@NgModule({
  declarations: [
    AppComponent,
    MyCustomPipe  // 👈 Add here
  ],
  ...
})
export class AppModule { }

<p>{{ 10 | myCustomPipe }}</p>   <!-- Output: 10.000 -->
<p>{{ value | myCustomPipe }}</p>  <!-- where value = 10 -->
*/

//******************************************************************
                /* what are boot strap ncomponentn
It’s the entry point of your Angular application — the component that Angular injects into the DOM first and starts the component tree from there.

By default, it’s usually:

bootstrap: [AppComponent]
in the @NgModule metadata.

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent] // 👈 This is the bootstrap component
})
export class AppModule { }


	•	Angular starts by rendering the bootstrap component.
	•	It gets inserted into the DOM via its selector (usually <app-root>).
	•	From there, the rest of the app is built using the component tree.


    Can You Have Multiple Bootstrap Components?

Not in the same Angular app. Each Angular app can only have one bootstrap component (but that component can render many child components).

For multiple entry points, you’d create multiple Angular apps or modules.


Bootstrap Component
First component Angular loads on app startup
Defined In
@NgModuleâ€™s bootstrap array
Usually
AppComponent

    */

//******************************************************************

                /* How angular know modules are loaded from app.module.ts
                *  @NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule],
  bootstrap: [AppComponent]
})
export class AppModule {}
This tells Angular:
	•	Which components are part of the app (declarations)
	•	What other modules are needed (imports)
	•	Which component to bootstrap first (bootstrap)


	Angular knows what other modules to load via the imports array:
imports: [
  BrowserModule,
  AppRoutingModule,
  SharedModule,
  FormsModule
]

*
* main.ts Entry point, bootstraps AppModule
AppModule Root module, defined in app.module.ts
imports[] in AppModule Defines other modules to load
bootstrap[] in AppModule Tells Angular which component to render first
* *
                 */
                /* first thing loaded in angular after index.html
                *
                * 1
index.html
Loads browser shell & <app-root>
2
main.ts
Bootstraps AppModule
3
app.module.ts
Declares components and bootstraps AppComponent
4
app.component.ts
Replaces <app-root> with actual content

* * *
                */
                /*what is main.ts used for
                *
                * Part
Description
main.ts
Entry point of Angular app
platformBrowserDynamic()
Bootstraps the app in browser with JIT
bootstrapModule()
Starts the app using the root module
AppModule
Root module containing the root component

* * *
                * where to load config in angular project* *
                *
                * Use Case
Method
Static config (compile-time)
environment.ts
Dynamic config (runtime)
Load JSON using APP_INITIALIZER
App secrets (not recommended)
Never store secrets in frontend apps


* *
                * * * * *
* * */
    }
}
