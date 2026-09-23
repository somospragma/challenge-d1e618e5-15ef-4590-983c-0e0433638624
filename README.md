# Rediseño de la pantalla de transferencias en Android

Debes rediseñar la pantalla de transferencias de una aplicación bancaria para Android. La pantalla debe separar las capas utilizando ViewModel y corrutinas, y manejar adecuadamente el ciclo de vida de las pantallas. La aplicación debe permitir al usuario iniciar una transferencia, mostrar el estado de la transferencia y manejar posibles errores. Los datos de la transferencia incluyen el monto, la cuenta de origen, la cuenta de destino y una descripción. La aplicación debe validar que el monto sea positivo y que las cuentas de origen y destino sean válidas. En caso de error en la transferencia, la aplicación debe mostrar un mensaje de error y permitir al usuario reintentar la operación.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Arquitectura de aplicaciones Android |
| **Nivel** | advanced-l1 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Gradle 8+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `gradle build` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición de requisitos y separación de capas

**Objetivo:** Definir los requisitos de la pantalla de transferencias y separar las capas utilizando ViewModel y corrutinas.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar los elementos de la pantalla de transferencias (monto, cuenta de origen, cuenta de destino, descripción).
- Definir las validaciones necesarias para cada elemento (monto positivo, cuentas válidas).
- Separar las capas de presentación, lógica y datos utilizando ViewModel y corrutinas.

**Entregable:** Documento de requisitos y diagrama de capas.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo separarías la lógica de la presentación.
- Considera cómo manejarías las validaciones en tiempo real.

</details>

### Fase 2: Implementación del ciclo de vida de las pantallas

**Objetivo:** Implementar el ciclo de vida de las pantallas para manejar correctamente los estados de la transferencia.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementar el ciclo de vida de las pantallas utilizando ViewModel.
- Manejar los estados de la transferencia (iniciada, en proceso, completada, error).
- Mostrar los estados correspondientes en la pantalla.

**Entregable:** Código implementado del ciclo de vida de las pantallas.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que el ciclo de vida de las pantallas debe manejar correctamente los estados de la transferencia.
- Piensa en cómo mostrarías los estados en la pantalla.

</details>

### Fase 3: Manejo de errores y reintentos

**Objetivo:** Implementar el manejo de errores y permitir reintentos en caso de fallo en la transferencia.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementar el manejo de errores en la transferencia.
- Permitir al usuario reintentar la transferencia en caso de error.
- Mostrar un mensaje de error adecuado en la pantalla.

**Entregable:** Código implementado del manejo de errores y reintentos.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que debes manejar correctamente los errores y permitir reintentos.
- Piensa en cómo mostrarías un mensaje de error adecuado en la pantalla.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es el ViewModel y cómo se usa en Android?
- **paraQueSirve**: ¿Para qué sirve separar las capas en una aplicación Android?
- **comoSeUsa**: ¿Cómo se implementa el ciclo de vida de las pantallas en Android?
- **erroresComunes**: ¿Cuáles son los errores comunes al manejar el ciclo de vida de las pantallas en Android?
- **queDecisionesImplica**: ¿Qué decisiones implica el manejo de errores y reintentos en una transferencia?

## Criterios de Evaluacion

- Definir correctamente los requisitos y separar las capas.
- Implementar correctamente el ciclo de vida de las pantallas.
- Manejar correctamente los errores y permitir reintentos.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
./gradlew assembleDebug
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
