# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Rediseño de la pantalla de transferencias en Android**.

| | |
|---|---|
| Tema | Arquitectura de aplicaciones Android |
| Nivel | advanced-l1 |
| Chapter | Móvil |
| Especialidad | Android |
| Stack | Kotlin 2.1 / Jetpack Compose con Material Design 3 |
| Patron arquitectonico | clean_architecture_mvvm |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `build.gradle.kts (raiz y modulo app)`
- `AndroidManifest.xml`
- `Application con @HiltAndroidApp`
- `Activity con setContent`
- `capa data con repositorios y Retrofit`
- `capa domain con casos de uso`
- `capa ui con screens y ViewModel`

Trampas conocidas:

- Las versiones de plugin y libreria en Gradle van completas (ej. `2.1.0`, no `2.1`).
- Compose se coordina con `androidx.compose:compose-bom`: las librerias de Compose van sin version propia.
- Hilt necesita su plugin de Gradle y el procesador de anotaciones (`ksp` o `kapt`), no alcanza la dependencia.

Dependencias:

- androidx.core:core-ktx 1.15.0
- androidx.lifecycle:lifecycle-runtime-ktx 2.8.7
- androidx.lifecycle:lifecycle-viewmodel-compose 2.8.7
- androidx.lifecycle:lifecycle-runtime-compose 2.8.7
- androidx.activity:activity-compose 1.9.3
- androidx.compose.ui:ui n/a
- androidx.compose.ui:ui-graphics n/a
- androidx.compose.ui:ui-tooling-preview n/a
- androidx.compose.material3:material3 n/a
- androidx.compose.material:material-icons-extended n/a
- androidx.navigation:navigation-compose 2.8.5
- androidx.hilt:hilt-navigation-compose 1.2.0
- com.google.dagger:hilt-android 2.52
- com.google.dagger:hilt-compiler 2.52
- org.jetbrains.kotlinx:kotlinx-coroutines-android 1.9.0
- org.jetbrains.kotlinx:kotlinx-coroutines-core 1.9.0
- com.squareup.retrofit2:retrofit 2.11.0
- com.squareup.retrofit2:converter-gson 2.11.0
- com.squareup.okhttp3:okhttp 4.12.0
- com.squareup.okhttp3:logging-interceptor 4.12.0
- com.google.code.gson:gson 2.11.0
- androidx.room:room-runtime 2.6.1
- androidx.room:room-ktx 2.6.1
- androidx.room:room-compiler 2.6.1
- org.jetbrains.kotlin:kotlin-gradle-plugin 2.1.0
- com.android.application 8.7.3
- com.google.dagger.hilt.android.gradle.plugin 2.52
- junit:junit 4.13.2
- org.jetbrains.kotlinx:kotlinx-coroutines-test 1.9.0
- androidx.arch.core:core-testing 2.2.0
- io.mockk:mockk 1.13.14

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `./gradlew assembleDebug` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `./gradlew assembleDebug` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición de requisitos y separación de capas**: Documento de requisitos y diagrama de capas.
- **Fase 2 — Implementación del ciclo de vida de las pantallas**: Código implementado del ciclo de vida de las pantallas.
- **Fase 3 — Manejo de errores y reintentos**: Código implementado del manejo de errores y reintentos.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `app/src/main/java/com/pragma/transferapp/data/repository/TransferRepositoryImpl.kt` — El topic pide persistencia: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (14)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `app/src/main/java/com/pragma/transferapp/MainActivity.kt` — `com.pragma.transferapp.ui.theme.TransferAppTheme`
      El import com.pragma.transferapp.ui.theme.TransferAppTheme usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `app/src/main/java/com/pragma/transferapp/MainActivity.kt` — `com.pragma.transferapp.navigation.NavGraph`
      El import com.pragma.transferapp.navigation.NavGraph usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `app/src/main/java/com/pragma/transferapp/presentation/ui/screens/TransferScreen.kt` — `com.pragma.transferapp.presentation.ui.components.TransferForm`
      El import com.pragma.transferapp.presentation.ui.components.TransferForm usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `app/src/main/java/com/pragma/transferapp/presentation/ui/screens/TransferScreen.kt` — `com.pragma.transferapp.presentation.ui.components.TransferStatus`
      El import com.pragma.transferapp.presentation.ui.components.TransferStatus usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `app/src/main/java/com/pragma/transferapp/presentation/navigation/Screen.kt` — `com.pragma.transferapp.presentation.ui.screens.TransferScreen`
      El import com.pragma.transferapp.presentation.ui.screens.TransferScreen usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `app/src/main/java/com/pragma/transferapp/presentation/navigation/NavGraph.kt` — `com.pragma.transferapp.presentation.ui.screens.TransferScreen`
      El import com.pragma.transferapp.presentation.ui.screens.TransferScreen usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `app/src/main/java/com/pragma/transferapp/presentation/navigation/NavGraph.kt` — `com.pragma.transferapp.presentation.ui.screens.HomeScreen`
      El import com.pragma.transferapp.presentation.ui.screens.HomeScreen usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `app/src/main/java/com/pragma/transferapp/di/RepositoryModule.kt` — `com.pragma.transferapp.data.repository.TransferRepository`
      El import com.pragma.transferapp.data.repository.TransferRepository usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `app/src/test/java/com/pragma/transferapp/TransferFundsUseCaseTest.kt` — `com.pragma.transferapp.data.repository.TransferRepository`
      El import com.pragma.transferapp.data.repository.TransferRepository usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `app/src/main/java/com/pragma/transferapp/presentation/viewmodel/TransferViewModel.kt` — `TransferResult`
      El import com.pragma.transferapp.domain.model.TransferResult no se usa en ningun lado del cuerpo del archivo. Se puede eliminar.
- [ ] `app/src/main/java/com/pragma/transferapp/presentation/viewmodel/TransferViewModel.kt` — `ValidateTransferUseCase.execute`
      Se invoca `execute` sobre `ValidateTransferUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `app/src/main/java/com/pragma/transferapp/presentation/viewmodel/TransferViewModel.kt` — `TransferFundsUseCase.execute`
      Se invoca `execute` sobre `TransferFundsUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `app/src/test/java/com/pragma/transferapp/ValidateTransferUseCaseTest.kt` — `ValidationUtils.validateAmount`
      Se invoca `validateAmount` sobre `ValidationUtils`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `app/src/test/java/com/pragma/transferapp/ValidateTransferUseCaseTest.kt` — `ValidationUtils.validateAccount`
      Se invoca `validateAccount` sobre `ValidationUtils`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (34)

- `build.gradle.kts`
- `app/build.gradle.kts`
- `app/src/main/java/com/pragma/transferapp/TransferApplication.kt`
- `app/src/main/java/com/pragma/transferapp/domain/model/Transfer.kt`
- `app/src/main/java/com/pragma/transferapp/domain/model/TransferState.kt`
- `app/src/main/java/com/pragma/transferapp/domain/model/TransferResult.kt`
- `app/src/main/java/com/pragma/transferapp/domain/repository/TransferRepository.kt`
- `app/src/main/java/com/pragma/transferapp/domain/usecase/TransferFundsUseCase.kt`
- `app/src/main/java/com/pragma/transferapp/domain/usecase/ValidateTransferUseCase.kt`
- `app/src/main/java/com/pragma/transferapp/data/remote/dto/TransferRequestDto.kt`
- `app/src/main/java/com/pragma/transferapp/data/remote/dto/TransferResponseDto.kt`
- `app/src/main/AndroidManifest.xml`
- `app/src/main/java/com/pragma/transferapp/MainActivity.kt`
- `app/src/main/java/com/pragma/transferapp/data/repository/TransferRepositoryImpl.kt`
- `app/src/main/java/com/pragma/transferapp/data/remote/api/TransferApiService.kt`
- `app/src/main/java/com/pragma/transferapp/presentation/viewmodel/TransferViewModel.kt`
- `app/src/main/java/com/pragma/transferapp/presentation/ui/screens/TransferScreen.kt`
- `app/src/main/java/com/pragma/transferapp/presentation/ui/components/TransferForm.kt`
- `app/src/main/java/com/pragma/transferapp/presentation/ui/components/TransferStatus.kt`
- `app/src/main/java/com/pragma/transferapp/presentation/ui/components/ErrorDialog.kt`
- `app/src/main/java/com/pragma/transferapp/presentation/navigation/Screen.kt`
- `app/src/main/java/com/pragma/transferapp/presentation/navigation/NavGraph.kt`
- `app/src/main/java/com/pragma/transferapp/di/NetworkModule.kt`
- `app/src/main/java/com/pragma/transferapp/di/RepositoryModule.kt`
- `app/src/main/java/com/pragma/transferapp/util/ValidationUtils.kt`
- `app/src/main/java/com/pragma/transferapp/util/Resource.kt`
- `app/src/main/res/values/strings.xml`
- `app/src/main/res/values/colors.xml`
- `app/src/main/res/values/themes.xml`
- `app/src/test/java/com/pragma/transferapp/TransferViewModelTest.kt`
- `app/src/test/java/com/pragma/transferapp/ValidateTransferUseCaseTest.kt`
- `app/src/test/java/com/pragma/transferapp/TransferFundsUseCaseTest.kt`
- `settings.gradle.kts`
- `gradle.properties`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `app/src/main/java/com/pragma/transferapp`
- `app/src/main/java/com/pragma/transferapp/presentation/ui/screens`
- `app/src/main/java/com/pragma/transferapp/presentation/ui/components`
- `app/src/main/java/com/pragma/transferapp/presentation/viewmodel`
- `app/src/main/java/com/pragma/transferapp/presentation/navigation`
- `app/src/main/java/com/pragma/transferapp/domain/model`
- `app/src/main/java/com/pragma/transferapp/domain/repository`
- `app/src/main/java/com/pragma/transferapp/domain/usecase`
- `app/src/main/java/com/pragma/transferapp/data/repository`
- `app/src/main/java/com/pragma/transferapp/data/remote/dto`
- `app/src/main/java/com/pragma/transferapp/data/remote/api`
- `app/src/main/java/com/pragma/transferapp/data/local`
- `app/src/main/java/com/pragma/transferapp/di`
- `app/src/main/java/com/pragma/transferapp/util`
- `app/src/main/res/values`
- `app/src/main/res/drawable`
- `app/src/test/java/com/pragma/transferapp`

## Verificacion

```bash
./gradlew assembleDebug
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **clean_architecture_mvvm**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Movil, Especialidad Desarrollador, Tecnología Android, Advanced
- Brecha que el reto ataca: Aplica separacion de capas con ViewModel y corrutinas, y entiende el ciclo de vida de las pantallas
- Mision: Rediseñar la pantalla de transferencias con separacion de capas

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
