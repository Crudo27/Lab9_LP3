# Laboratorio 09 - Lenguajes de Programación III

Universidad Católica de Santa María - Ingeniería de Sistemas.

Este repositorio reúne las **Actividades** y los **Ejercicios** de la guía de Laboratorio 09 (Java Swing básico: introducción y controles).

## 1. Actividad: administradores de esquemas

El código original se conserva en `actividad_Lab9/src/actividad_Lab9/`:

- `App.java`: inicia la ventana principal.
- `MarcoPanel.java`: abre demostraciones independientes de `FlowLayout`, `BorderLayout` y `GridLayout`.

Para ejecutar, inicie `actividad_Lab9.App` como **Java Application** en Eclipse.

## 2. Ejercicio 1: constructor visual

Se describe el uso de **Eclipse WindowBuilder** en el informe ubicado en `documentacion/`. Allí aparecen ilustraciones didácticas simuladas, **no capturas reales de Eclipse**. La herramienta permite alternar Design/Source y agregar controles Swing mediante arrastrar y soltar.

## 3. Ejercicio 2: compra de pasajes

Código en `actividad_Lab9/src/ejercicios_Lab9/`:

- `AppPasajes.java`: inicia la GUI en el hilo de eventos y selecciona Nimbus cuando está disponible.
- `VentanaPasajes.java`: construye el formulario y registra eventos de los botones.
- `Pasaje.java`: modelo inmutable de los datos y generación de resumen.

Para ejecutar, inicie `ejercicios_Lab9.AppPasajes` como **Java Application** en Eclipse. También se puede compilar desde el proyecto con JDK 17 o superior. El proyecto Eclipse de origen configura JavaSE-25; si su instalación usa otra versión, cambie el JRE de Eclipse.

### Controles implementados

- `JLabel`: rótulos.
- `JTextField`: nombre, documento y fecha.
- `JButton`: resumen y limpieza.
- `JCheckBox`: audífonos, manta y revistas.
- `JRadioButton` + `ButtonGroup`: primer o segundo piso.
- `JComboBox`: origen y destino.
- `JList`: económico, standard o VIP.
- `JOptionPane`: advertencias y resumen final.

Validaciones: nombre no vacío; DNI de ocho cifras; fecha válida y no anterior al día actual; origen y destino elegidos y distintos; piso y categoría seleccionados. El formulario académico no realiza pagos, reservas reales ni persistencia de datos.

## Evidencias

- `documentacion/evidencias/01-04`: capturas reales de la actividad aportadas por el estudiante.
- `documentacion/evidencias/05-09`: capturas **reales** de la aplicación ejecutada en entorno gráfico de pruebas Java/Xvfb.
- `documentacion/evidencias/10-11`: **ilustraciones simuladas** de un posible flujo en WindowBuilder; no representan una sesión de Eclipse verificada.

## Documento

El PDF y DOCX del informe detallado se incluyen en `documentacion/`.