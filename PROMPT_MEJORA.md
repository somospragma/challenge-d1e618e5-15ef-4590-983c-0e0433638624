# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `app/src/main/java/com/pragma/transferapp/data/repository/TransferRepositoryImpl.kt` — El topic pide persistencia: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `app/src/main/java/com/pragma/transferapp/MainActivity.kt` — `com.pragma.transferapp.ui.theme.TransferAppTheme`: El import com.pragma.transferapp.ui.theme.TransferAppTheme usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `app/src/main/java/com/pragma/transferapp/MainActivity.kt` — `com.pragma.transferapp.navigation.NavGraph`: El import com.pragma.transferapp.navigation.NavGraph usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `app/src/main/java/com/pragma/transferapp/presentation/ui/screens/TransferScreen.kt` — `com.pragma.transferapp.presentation.ui.components.TransferForm`: El import com.pragma.transferapp.presentation.ui.components.TransferForm usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `app/src/main/java/com/pragma/transferapp/presentation/ui/screens/TransferScreen.kt` — `com.pragma.transferapp.presentation.ui.components.TransferStatus`: El import com.pragma.transferapp.presentation.ui.components.TransferStatus usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `app/src/main/java/com/pragma/transferapp/presentation/navigation/Screen.kt` — `com.pragma.transferapp.presentation.ui.screens.TransferScreen`: El import com.pragma.transferapp.presentation.ui.screens.TransferScreen usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `app/src/main/java/com/pragma/transferapp/presentation/navigation/NavGraph.kt` — `com.pragma.transferapp.presentation.ui.screens.TransferScreen`: El import com.pragma.transferapp.presentation.ui.screens.TransferScreen usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `app/src/main/java/com/pragma/transferapp/presentation/navigation/NavGraph.kt` — `com.pragma.transferapp.presentation.ui.screens.HomeScreen`: El import com.pragma.transferapp.presentation.ui.screens.HomeScreen usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `app/src/main/java/com/pragma/transferapp/di/RepositoryModule.kt` — `com.pragma.transferapp.data.repository.TransferRepository`: El import com.pragma.transferapp.data.repository.TransferRepository usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `app/src/test/java/com/pragma/transferapp/TransferFundsUseCaseTest.kt` — `com.pragma.transferapp.data.repository.TransferRepository`: El import com.pragma.transferapp.data.repository.TransferRepository usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `app/src/main/java/com/pragma/transferapp/presentation/viewmodel/TransferViewModel.kt` — `TransferResult`: El import com.pragma.transferapp.domain.model.TransferResult no se usa en ningun lado del cuerpo del archivo. Se puede eliminar.
- `app/src/main/java/com/pragma/transferapp/presentation/viewmodel/TransferViewModel.kt` — `ValidateTransferUseCase.execute`: Se invoca `execute` sobre `ValidateTransferUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `app/src/main/java/com/pragma/transferapp/presentation/viewmodel/TransferViewModel.kt` — `TransferFundsUseCase.execute`: Se invoca `execute` sobre `TransferFundsUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `app/src/test/java/com/pragma/transferapp/ValidateTransferUseCaseTest.kt` — `ValidationUtils.validateAmount`: Se invoca `validateAmount` sobre `ValidationUtils`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `app/src/test/java/com/pragma/transferapp/ValidateTransferUseCaseTest.kt` — `ValidationUtils.validateAccount`: Se invoca `validateAccount` sobre `ValidationUtils`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
./gradlew assembleDebug
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Movil, Especialidad Desarrollador, Tecnología Android, Advanced

### Brecha de conocimiento
Aplica separacion de capas con ViewModel y corrutinas, y entiende el ciclo de vida de las pantallas

### Misión / candidato
Rediseñar la pantalla de transferencias con separacion de capas

### Datos adicionales
Candidato con 3 años en Android

### Reto
- Tema: Arquitectura de aplicaciones Android
- Seniority: advanced-l1
- Tipo: practical
- Título: Rediseño de la pantalla de transferencias en Android
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición de requisitos y separación de capas — objetivo: Definir los requisitos de la pantalla de transferencias y separar las capas utilizando ViewModel y corrutinas. — entregable (NO resolver): Documento de requisitos y diagrama de capas.
- Fase 2: Implementación del ciclo de vida de las pantallas — objetivo: Implementar el ciclo de vida de las pantallas para manejar correctamente los estados de la transferencia. — entregable (NO resolver): Código implementado del ciclo de vida de las pantallas.
- Fase 3: Manejo de errores y reintentos — objetivo: Implementar el manejo de errores y permitir reintentos en caso de fallo en la transferencia. — entregable (NO resolver): Código implementado del manejo de errores y reintentos.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: build.gradle.kts ===
plugins {
    id("com.android.application") version "8.7.3"
    id("org.jetbrains.kotlin.android") version "2.1.0"
    id("com.google.dagger.hilt.android") version "2.52"
    kotlin("kapt") version "2.1.0"
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.7.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.52")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

android {
    namespace = "com.pragma.transferapp"
    compileSdk = 35

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    defaultConfig {
        applicationId = "com.pragma.transferapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    flavorDimensions += "environment"
    productFlavors {
        create("dev") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", '"https://dev.api.transferapp.com/"')
        }
        create("prod") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", '"https://api.transferapp.com/"')
        }
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2024.09.00")
    implementation(composeBom)

    // Core dependencies
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")

    // Compose dependencies
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.8.5")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.52")
    kapt("com.google.dagger:hilt-compiler:2.52")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")

    // Networking
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.google.code.gson:gson:2.11.0")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("io.mockk:mockk:1.13.14")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(composeBom)
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

// === ARCHIVO: app/build.gradle.kts ===
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.pragma.transferapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pragma.transferapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2024.09.00")
    implementation(composeBom)

    // Core dependencies
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
    implementation("androidx.activity:activity-compose:1.9.3")

    // Compose dependencies
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.8.5")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.52")
    kapt("com.google.dagger:hilt-compiler:2.52")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")

    // Networking
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("io.mockk:mockk:1.13.14")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/TransferApplication.kt ===
package com.pragma.transferapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class TransferApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/domain/model/Transfer.kt ===
import com.pragma.transferapp.util.Error;
import com.pragma.transferapp.util.Success;
package com.pragma.transferapp.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

/**
 * Representa una transferencia bancaria entre cuentas.
 * Incluye validaciones de negocio para asegurar que el monto sea positivo
 * y que las cuentas de origen y destino sean válidas.
 */
data class Transfer(
    val id: UUID = UUID.randomUUID(),
    val amount: BigDecimal,
    val sourceAccount: String,
    val destinationAccount: String,
    val description: String?,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val transferReference: String = generateReference()
) {
    init {
        require(amount > BigDecimal.ZERO) { "El monto debe ser positivo" }
        require(sourceAccount.isNotBlank()) { "La cuenta de origen no puede estar vacía" }
        require(destinationAccount.isNotBlank()) { "La cuenta de destino no puede estar vacía" }
        require(sourceAccount != destinationAccount) { "Las cuentas de origen y destino deben ser diferentes" }
    }

    companion object {
        private fun generateReference(): String {
            return "TRF-${UUID.randomUUID().toString().substring(0, 8).uppercase()}"
        }

        fun createPendingTransfer(
            amount: BigDecimal,
            sourceAccount: String,
            destinationAccount: String,
            description: String?
        ): Transfer {
            return Transfer(
                amount = amount,
                sourceAccount = sourceAccount,
                destinationAccount = destinationAccount,
                description = description?.takeIf { it.isNotBlank() }
            )
        }
    }

    fun toSuccessResult(transactionId: String): TransferResult {
        return TransferResult.Success(
            transferId = this.id,
            transactionId = transactionId,
            amount = this.amount,
            reference = this.transferReference,
            timestamp = this.createdAt
        )
    }

    fun toErrorResult(errorMessage: String): TransferResult {
        return TransferResult.Error(
            transferId = this.id,
            errorMessage = errorMessage,
            timestamp = LocalDateTime.now()
        )
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/domain/model/TransferState.kt ===
package com.pragma.transferapp.domain.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Representa los diferentes estados por los que pasa una transferencia durante su ciclo de vida.
 * Incluye manejo de transiciones entre estados y validaciones para evitar estados inválidos.
 */
sealed class TransferState {
    object Idle : TransferState()
    object Loading : TransferState()
    data class Success(val result: TransferResult.Success) : TransferState()
    data class Error(val error: TransferResult.Error) : TransferState()

    /**
     * Clase que gestiona el estado de la transferencia con corrutinas.
     * Proporciona métodos para actualizar el estado de manera segura desde ViewModel.
     */
    class TransferStateManager {
        private val _state = MutableStateFlow<TransferState>(Idle)
        val state: StateFlow<TransferState> = _state.asStateFlow()

        fun transitionToLoading() {
            _state.update { Loading }
        }

        fun transitionToSuccess(result: TransferResult.Success) {
            require(_state.value is Loading) {
                "No se puede transicionar a Success desde ${_state.value::class.simpleName}"
            }
            _state.update { Success(result) }
        }

        fun transitionToError(error: TransferResult.Error) {
            _state.update { Error(error) }
        }

        fun resetToIdle() {
            _state.update { Idle }
        }

        fun isLoading(): Boolean = _state.value is Loading
    }

    /**
     * Extensión para ViewModel que facilita la gestión del estado.
     */
    fun interface StateTransitionHandler {
        suspend fun handleStateTransition(
            onLoading: suspend () -> Unit,
            onSuccess: suspend (TransferResult.Success) -> Unit,
            onError: suspend (TransferResult.Error) -> Unit
        )
    }

    companion object {
        fun createTransitionHandler(stateFlow: StateFlow<TransferState>): StateTransitionHandler {
            return StateTransitionHandler { onLoading, onSuccess, onError ->
                stateFlow.collect { currentState ->
                    when (currentState) {
                        is Loading -> onLoading()
                        is Success -> onSuccess(currentState.result)
                        is Error -> onError(currentState.error)
                        Idle -> { /* No action needed */ }
                    }
                }
            }
        }

        fun validateTransition(current: TransferState, next: TransferState): Boolean {
            return when (current) {
                Idle -> next is Loading
                Loading -> next is Success || next is Error
                is Success -> next == Idle
                is Error -> next == Idle
            }
        }
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/domain/model/TransferResult.kt ===
package com.pragma.transferapp.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

/**
 * Resultado de una transferencia bancaria.
 * Puede ser exitoso con detalles de la transacción o fallido con información del error.
 */
sealed class TransferResult {
    data class Success(
        val transferId: UUID,
        val transactionId: String,
        val amount: BigDecimal,
        val reference: String,
        val timestamp: LocalDateTime
    ) : TransferResult() {
        fun formattedAmount(): String = "$${amount.setScale(2, BigDecimal.ROUND_HALF_EVEN)}"

        fun confirmationMessage(): String {
            return "Transferencia exitosa de $${amount.setScale(2)} a la cuenta $reference. " +
                   "ID de transacción: $transactionId"
        }
    }

    data class Error(
        val transferId: UUID,
        val errorMessage: String,
        val timestamp: LocalDateTime = LocalDateTime.now(),
        val errorCode: String? = null,
        val retryable: Boolean = true
    ) : TransferResult() {
        fun userFriendlyMessage(): String {
            return when {
                errorMessage.contains("insufficient funds") ->
                    "Fondos insuficientes en la cuenta de origen"
                errorMessage.contains("account not found") ->
                    "Cuenta de destino no encontrada"
                errorMessage.contains("timeout") ->
                    "Tiempo de espera agotado. Por favor, reintente"
                else -> "Error al procesar la transferencia: $errorMessage"
            }
        }

        fun shouldAllowRetry(): Boolean = retryable

        companion object {
            fun fromException(exception: Exception, transferId: UUID): Error {
                return Error(
                    transferId = transferId,
                    errorMessage = exception.message ?: "Error desconocido",
                    errorCode = exception::class.simpleName,
                    retryable = when (exception) {
                        is java.net.SocketTimeoutException -> true
                        is java.io.IOException -> true
                        else -> false
                    }
                )
            }
        }
    }

    fun isSuccess(): Boolean = this is Success
    fun isError(): Boolean = this is Error

    /**
     * Convierte el resultado a un formato adecuado para persistencia local.
     */
    fun toPersistenceModel(): PersistenceTransferResult {
        return when (this) {
            is Success -> PersistenceTransferResult.Success(
                transferId = this.transferId.toString(),
                transactionId = this.transactionId,
                amount = this.amount.toPlainString(),
                reference = this.reference,
                timestamp = this.timestamp.toString()
            )
            is Error -> PersistenceTransferResult.Error(
                transferId = this.transferId.toString(),
                errorMessage = this.errorMessage,
                timestamp = this.timestamp.toString(),
                errorCode = this.errorCode,
                retryable = this.retryable
            )
        }
    }
}

/**
 * Modelo interno para persistencia local que evita problemas con tipos complejos.
 */
sealed class PersistenceTransferResult {
    data class Success(
        val transferId: String,
        val transactionId: String,
        val amount: String,
        val reference: String,
        val timestamp: String
    ) : PersistenceTransferResult()

    data class Error(
        val transferId: String,
        val errorMessage: String,
        val timestamp: String,
        val errorCode: String?,
        val retryable: Boolean
    ) : PersistenceTransferResult()
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/domain/repository/TransferRepository.kt ===
import com.pragma.transferapp.domain.model.TransferResult;
package com.pragma.transferapp.domain.repository

import com.pragma.transferapp.domain.model.Transfer
import kotlinx.coroutines.flow.Flow

interface TransferRepository {
    suspend fun transferFunds(transfer: Transfer): Flow<TransferResult>
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/domain/usecase/TransferFundsUseCase.kt ===
import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Loading;
package com.pragma.transferapp.domain.usecase

import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.model.TransferResult
import com.pragma.transferapp.domain.repository.TransferRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TransferFundsUseCase @Inject constructor(
    private val transferRepository: TransferRepository,
    private val coroutineDispatcher: CoroutineDispatcher
) {
    operator fun invoke(transfer: Transfer): Flow<TransferResult> = flow {
        emit(TransferResult.Loading)
        try {
            val result = transferRepository.transferFunds(transfer)
            emit(result)
        } catch (e: Exception) {
            emit(TransferResult.Error(e.message?: "Unknown error"))
        }
    }.flowOn(coroutineDispatcher)
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/domain/usecase/ValidateTransferUseCase.kt ===
package com.pragma.transferapp.domain.usecase

import com.pragma.transferapp.domain.model.Transfer
import javax.inject.Inject

class ValidateTransferUseCase @Inject constructor() {
    operator fun invoke(transfer: Transfer): Result<Transfer> {
        return if (transfer.amount > 0 && transfer.sourceAccount.isNotBlank() && transfer.destinationAccount.isNotBlank()) {
            Result.success(transfer)
        } else {
            Result.failure(Exception("Invalid transfer data"))
        }
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/data/remote/dto/TransferRequestDto.kt ===
package com.pragma.transferapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TransferRequestDto(
    @SerializedName("amount") val amount: Double,
    @SerializedName("sourceAccount") val sourceAccount: String,
    @SerializedName("destinationAccount") val destinationAccount: String,
    @SerializedName("description") val description: String
) {
    init {
        require(amount > 0) { "Amount must be positive" }
        require(sourceAccount.isNotBlank()) { "Source account must not be blank" }
        require(destinationAccount.isNotBlank()) { "Destination account must not be blank" }
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/data/remote/dto/TransferResponseDto.kt ===
package com.pragma.transferapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TransferResponseDto(
    @SerializedName("transactionId") val transactionId: String,
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String
) {
    init {
        require(transactionId.isNotBlank()) { "Transaction ID must not be blank" }
        require(status.isNotBlank()) { "Status must not be blank" }
        require(message.isNotBlank()) { "Message must not be blank" }
    }
}

// === ARCHIVO: app/src/main/AndroidManifest.xml ===
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.pragma.transferapp">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.TransferApp">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

    <uses-permission android:name="android.permission.INTERNET" />
</manifest>

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/MainActivity.kt ===
package com.pragma.transferapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pragma.transferapp.ui.theme.TransferAppTheme
import com.pragma.transferapp.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransferAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    NavGraph()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    androidx.compose.material3.Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TransferAppTheme {
        Greeting("Android")
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/data/repository/TransferRepositoryImpl.kt ===
import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.repository.TransferRepository;
package com.pragma.transferapp.data.repository

import com.pragma.transferapp.data.remote.api.TransferApiService
import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.model.TransferResult
import javax.inject.Inject

class TransferRepositoryImpl @Inject constructor(
    private val apiService: TransferApiService
) : TransferRepository {
    override suspend fun transferFunds(transfer: Transfer): TransferResult {
        // Implementación pendiente
        return TransferResult.Error("Pendiente de implementar")
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/data/remote/api/TransferApiService.kt ===
package com.pragma.transferapp.data.remote.api

import retrofit2.http.Body
import retrofit2.http.POST
import com.pragma.transferapp.data.remote.dto.TransferRequestDto
import com.pragma.transferapp.data.remote.dto.TransferResponseDto

interface TransferApiService {
    @POST("transfers")
    suspend fun transferFunds(@Body transferRequest: TransferRequestDto): TransferResponseDto
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/presentation/viewmodel/TransferViewModel.kt ===
import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Success;
import com.pragma.transferapp.domain.model.Loading;
import com.pragma.transferapp.domain.model.Idle;
package com.pragma.transferapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.model.TransferResult
import com.pragma.transferapp.domain.model.TransferState
import com.pragma.transferapp.domain.usecase.TransferFundsUseCase
import com.pragma.transferapp.domain.usecase.ValidateTransferUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class TransferViewModel @Inject constructor(
    private val validateTransferUseCase: ValidateTransferUseCase,
    private val transferFundsUseCase: TransferFundsUseCase
) : ViewModel() {

    private val _transferState = MutableStateFlow<TransferState>(TransferState.Idle)
    val transferState: StateFlow<TransferState> = _transferState

    fun transferFunds(transfer: Transfer) {
        viewModelScope.launch {
            val validationResult = validateTransferUseCase.execute(transfer)
            if (validationResult.isSuccess()) {
                _transferState.value = TransferState.Loading
                val transferResult = transferFundsUseCase.execute(transfer)
                if (transferResult.isSuccess()) {
                    _transferState.value = TransferState.Success(transferResult.toSuccessResult())
                } else {
                    _transferState.value = TransferState.Error(transferResult.toErrorResult())
                }
            } else {
                _transferState.value = TransferState.Error(validationResult.toErrorResult())
            }
        }
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/presentation/ui/screens/TransferScreen.kt ===
import com.pragma.transferapp.domain.model.Transfer;
package com.pragma.transferapp.presentation.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pragma.transferapp.presentation.ui.components.TransferForm
import com.pragma.transferapp.presentation.ui.components.TransferStatus
import com.pragma.transferapp.presentation.viewmodel.TransferViewModel

@Composable
fun TransferScreen() {
    val viewModel: TransferViewModel = viewModel()
    val transferState by viewModel.transferState.collectAsState()
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        TransferForm(onTransfer = { transfer ->
            viewModel.transferFunds(transfer)
        })
        TransferStatus(transferState) { error ->
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        }
        Button(onClick = { viewModel.transferFunds(Transfer()) }, modifier = Modifier.padding(top = 16.dp)) {
            Text("Transferir")
        }
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/presentation/ui/components/TransferForm.kt ===
package com.pragma.transferapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pragma.transferapp.domain.model.Transfer

@Composable
fun TransferForm(onTransfer: (Transfer) -> Unit) {
    val amount = remember { mutableStateOf("") }
    val sourceAccount = remember { mutableStateOf("") }
    val destinationAccount = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = amount.value,
            onValueChange = { amount.value = it },
            label = { Text("Monto") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = sourceAccount.value,
            onValueChange = { sourceAccount.value = it },
            label = { Text("Cuenta de origen") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = destinationAccount.value,
            onValueChange = { destinationAccount.value = it },
            label = { Text("Cuenta de destino") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Descripción") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/presentation/ui/components/TransferStatus.kt ===
import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Success;
import com.pragma.transferapp.domain.model.Loading;
import com.pragma.transferapp.domain.model.Transfer;
import com.pragma.transferapp.domain.model.Idle;
package com.pragma.transferapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pragma.transferapp.domain.model.TransferState

@Composable
fun TransferStatus(transferState: TransferState) {
    Column(modifier = Modifier.padding(16.dp)) {
        when (transferState) {
            is TransferState.Idle -> Text("Transfer is idle", style = MaterialTheme.typography.bodyMedium)
            is TransferState.Loading -> Text("Transfer is in progress", style = MaterialTheme.typography.bodyMedium)
            is TransferState.Success -> Text("Transfer completed successfully", style = MaterialTheme.typography.bodyMedium)
            is TransferState.Error -> Text("Transfer failed: ${transferState.error.message}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/presentation/ui/components/ErrorDialog.kt ===
import com.pragma.transferapp.domain.model.Error;
package com.pragma.transferapp.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorDialog(
    errorMessage: String,
    onRetry: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        title = { Text("Error") },
        text = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(errorMessage)
            }
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onRetry) {
                Text("Retry")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Dismiss")
            }
        }
    )
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/presentation/navigation/Screen.kt ===
package com.pragma.transferapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pragma.transferapp.presentation.ui.screens.TransferScreen

sealed class Screen(val route: String) {
    object Transfer : Screen("transfer")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Transfer.route) {
        composable(Screen.Transfer.route) {
            TransferScreen(navController)
        }
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/presentation/navigation/NavGraph.kt ===
import com.pragma.transferapp.domain.model.Transfer;
package com.pragma.transferapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pragma.transferapp.presentation.ui.screens.TransferScreen
import com.pragma.transferapp.presentation.ui.screens.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Transfer.route) {
            TransferScreen(navController)
        }
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/di/NetworkModule.kt ===
package com.pragma.transferapp.di

import com.pragma.transferapp.data.remote.api.TransferApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
           .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
           .add(KotlinJsonAdapterFactory())
           .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
           .baseUrl("https://api.transferapp.com/")
           .client(okHttpClient)
           .addConverterFactory(MoshiConverterFactory.create(moshi))
           .build()
    }

    @Provides
    @Singleton
    fun provideTransferApiService(retrofit: Retrofit): TransferApiService {
        return retrofit.create(TransferApiService::class.java)
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/di/RepositoryModule.kt ===
package com.pragma.transferapp.di

import com.pragma.transferapp.data.repository.TransferRepository
import com.pragma.transferapp.data.repository.TransferRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTransferRepository(transferRepositoryImpl: TransferRepositoryImpl): TransferRepository {
        return transferRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideTransferRepositoryImpl(): TransferRepositoryImpl {
        return TransferRepositoryImpl()
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/util/ValidationUtils.kt ===
package com.pragma.transferapp.util

import com.pragma.transferapp.domain.model.Transfer

object ValidationUtils {

    fun validateTransfer(transfer: Transfer): ValidationResult {
        if (transfer.amount <= 0) {
            return ValidationResult.Error("El monto debe ser positivo.")
        }
        if (transfer.sourceAccount.isBlank() || transfer.destinationAccount.isBlank()) {
            return ValidationResult.Error("Las cuentas de origen y destino deben ser válidas.")
        }
        return ValidationResult.Success
    }

    sealed class ValidationResult {
        object Success : ValidationResult()
        data class Error(val message: String) : ValidationResult()
    }
}

// === ARCHIVO: app/src/main/java/com/pragma/transferapp/util/Resource.kt ===
package com.pragma.transferapp.util

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

// === ARCHIVO: app/src/main/res/values/strings.xml ===
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">TransferApp</string>
    <string name="transfer_title">Transferir Fondos</string>
    <string name="amount_label">Monto</string>
    <string name="source_account_label">Cuenta de Origen</string>
    <string name="destination_account_label">Cuenta de Destino</string>
    <string name="description_label">Descripción</string>
    <string name="transfer_button">Transferir</string>
    <string name="error_message">Ha ocurrido un error al realizar la transferencia.</string>
    <string name="retry_message">¿Desea reintentar la transferencia?</string>
</resources>

// === ARCHIVO: app/src/main/res/values/colors.xml ===
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#6200EE</color>
    <color name="colorPrimaryDark">#3700B3</color>
    <color name="colorAccent">#03DAC5</color>
    <color name="colorError">#FF5252</color>
    <color name="colorSuccess">#4CAF50</color>
</resources>

// === ARCHIVO: app/src/main/res/values/themes.xml ===
<?xml version="1.0" encoding="utf-8"?>
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.TransferApp" parent="Theme.Material3.DayNight.NoActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryVariant">@color/colorPrimaryDark</item>
        <item name="colorOnPrimary">@android:color/white</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/colorAccent</item>
        <item name="colorSecondaryVariant">@color/colorAccent</item>
        <item name="colorOnSecondary">@android:color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">@color/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
    </style>
</resources>

// === ARCHIVO: app/src/test/java/com/pragma/transferapp/TransferViewModelTest.kt ===
import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Transfer;
import com.pragma.transferapp.domain.model.Success;
import com.pragma.transferapp.domain.model.TransferResult;
import com.pragma.transferapp.domain.model.Loading;
import com.pragma.transferapp.domain.model.TransferState;
import com.pragma.transferapp.domain.model.Idle;
import com.pragma.transferapp.domain.usecase.TransferFundsUseCase;
import com.pragma.transferapp.presentation.viewmodel.TransferViewModel;
package com.pragma.transferapp

import androidx.arch.core.executor.testing.CountingTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class TransferViewModelTest {

    @get:Rule
    val countingTaskExecutorRule = CountingTaskExecutorRule()

    private lateinit var viewModel: TransferViewModel
    private val mockTransferUseCase = mock(TransferFundsUseCase::class.java)

    @Before
    fun setup() {
        viewModel = TransferViewModel(mockTransferUseCase)
    }

    @Test
    fun `test initial state is Idle`() = runTest {
        assertThat(viewModel.state.value).isEqualTo(TransferState.Idle)
    }

    @Test
    fun `test transferFunds updates state correctly`() = runTest {
        viewModel.transferFunds("100", "account1", "account2", "Description")
        verify(mockTransferUseCase).invoke("100", "account1", "account2", "Description")
        assertThat(viewModel.state.value).isInstanceOf(TransferState.Loading::class.java)
    }

    @Test
    fun `test transferFunds handles success`() = runTest {
        val mockResult = TransferResult.Success(Transfer(id = "1", amount = "100", from = "account1", to = "account2", description = "Description"))
        mockTransferUseCase.invoke("100", "account1", "account2", "Description").thenReturn(mockResult)
        viewModel.transferFunds("100", "account1", "account2", "Description")
        assertThat(viewModel.state.value).isInstanceOf(TransferState.Success::class.java)
    }

    @Test
    fun `test transferFunds handles error`() = runTest {
        val mockResult = TransferResult.Error("Error message")
        mockTransferUseCase.invoke("100", "account1", "account2", "Description").thenReturn(mockResult)
        viewModel.transferFunds("100", "account1", "account2", "Description")
        assertThat(viewModel.state.value).isInstanceOf(TransferState.Error::class.java)
    }
}

// === ARCHIVO: app/src/test/java/com/pragma/transferapp/ValidateTransferUseCaseTest.kt ===
import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.Success;
import com.pragma.transferapp.domain.model.TransferResult;
package com.pragma.transferapp.test

import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.usecase.ValidateTransferUseCase
import com.pragma.transferapp.util.ValidationUtils
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ValidateTransferUseCaseTest {

    private val validationUtils: ValidationUtils = mockk()
    private val validateTransferUseCase = ValidateTransferUseCase(validationUtils)

    @Test
    fun `validate transfer returns success when amount is positive and accounts are valid`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "123456789", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { validationUtils.validateAmount(any()) } returns true
        coEvery { validationUtils.validateAccount(any()) } returns true

        val result = validateTransferUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Success, result)
    }

    @Test
    fun `validate transfer returns error when amount is negative`() = runTest {
        val transfer = Transfer(amount = -100.0, sourceAccount = "123456789", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { validationUtils.validateAmount(any()) } returns false
        coEvery { validationUtils.validateAccount(any()) } returns true

        val result = validateTransferUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Error("Invalid amount"), result)
    }

    @Test
    fun `validate transfer returns error when source account is invalid`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "invalid", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { validationUtils.validateAmount(any()) } returns true
        coEvery { validationUtils.validateAccount(any()) } returns false

        val result = validateTransferUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Error("Invalid source account"), result)
    }

    @Test
    fun `validate transfer returns error when destination account is invalid`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "123456789", destinationAccount = "invalid", description = "Test Transfer")

        coEvery { validationUtils.validateAmount(any()) } returns true
        coEvery { validationUtils.validateAccount(any()) } returns false

        val result = validateTransferUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Error("Invalid destination account"), result)
    }
}

// === ARCHIVO: app/src/test/java/com/pragma/transferapp/TransferFundsUseCaseTest.kt ===
import com.pragma.transferapp.domain.model.Error;
import com.pragma.transferapp.domain.model.TransferResult;
import com.pragma.transferapp.domain.model.Success;
package com.pragma.transferapp.test

import com.pragma.transferapp.data.repository.TransferRepository
import com.pragma.transferapp.domain.model.Transfer
import com.pragma.transferapp.domain.usecase.TransferFundsUseCase
import com.pragma.transferapp.util.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class TransferFundsUseCaseTest {

    private val transferRepository: TransferRepository = mockk()
    private val transferFundsUseCase = TransferFundsUseCase(transferRepository)

    @Test
    fun `transfer funds returns success when repository call is successful`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "123456789", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { transferRepository.transferFunds(any()) } returns Resource.Success(Transfer.TransferResult.Success)

        val result = transferFundsUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Success, result)
    }

    @Test
    fun `transfer funds returns error when repository call fails`() = runTest {
        val transfer = Transfer(amount = 100.0, sourceAccount = "123456789", destinationAccount = "987654321", description = "Test Transfer")

        coEvery { transferRepository.transferFunds(any()) } returns Resource.Error("Transfer failed")

        val result = transferFundsUseCase.execute(transfer)

        assertEquals(Transfer.TransferResult.Error("Transfer failed"), result)
    }
}

// === ARCHIVO: settings.gradle.kts ===
rootProject.name = "transferapp"
include(":app")

// === ARCHIVO: gradle.properties ===
# Project-wide Gradle properties
# These properties are used by the project and can be overridden in the local.properties file
org.gradle.jvmargs=-Xmx2048m
android.useAndroidX=true
android.enableJetifier=true
kapt.use.worker.api=true

# Gradle Kotlin DSL settings
kotlin.code.style=official
```
