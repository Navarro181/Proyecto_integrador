document.addEventListener("DOMContentLoaded", () => {
  // Obtener el contenedor del sidebar y agregar un evento de clic
  document.querySelector(".sidebar").addEventListener("click", function (e) {
    // Verificar si el clic fue sobre un botón
    if (e.target.tagName === "BUTTON") {
      // Extraer el valor del atributo onclick directamente del botón clickeado
      const sectionId = e.target.getAttribute("onclick").match(/'([^']+)'/)[1];
      // Llamar a toggleSection con el ID obtenido
      toggleSection(sectionId);
    }
  });

  // Inicializar la página mostrando solo la sección de 'Datos personales'
  toggleSection("datosPaciente");

  // Función para mostrar/ocultar secciones
  function toggleSection(sectionId) {
    // Obtener todas las secciones dentro del contenedor principal
    const sections = document.querySelectorAll("#principal > section");
    // Ocultar todas las secciones
    sections.forEach((section) => {
      section.style.display = "none";
    });

    // Mostrar la sección seleccionada
    const selectedSection = document.getElementById(sectionId);
    if (selectedSection) {
      selectedSection.style.display = "block";
    }
  }
});

const municipios = [
  "Madrid",
  "Alcalá de Henares",
  "Alcobendas",
  "Alcorcón",
  "Getafe",
  "Leganés",
  "Móstoles",
  "Parla",
  "Torrejón de Ardoz",
  "Fuenlabrada",
  "Pozuelo de Alarcón",
  "San Sebastián de los Reyes",
  "Rivas-Vaciamadrid",
  "Valdemoro",
  "Majadahonda",
  "Collado Villalba",
  "Aranjuez",
  "Arganda del Rey",
  "Boadilla del Monte",
  "Pinto",
  "Las Rozas de Madrid",
  "Coslada",
  "San Fernando de Henares",
  "Galapagar",
  "Arroyomolinos",
  "Villaviciosa de Odón",
  "Navalcarnero",
  "Ciempozuelos",
  "Torrelodones",
  "Paracuellos de Jarama",
  "Tres Cantos",
  "El Escorial",
  "Algete",
];

const searchBox = document.getElementById("search-box");
const suggestionsPanel = document.getElementById("suggestions");

searchBox.addEventListener("input", () => {
  const input = searchBox.value.toLowerCase();
  suggestionsPanel.innerHTML = "";
  const suggestions = municipios.filter((municipio) =>
    municipio.toLowerCase().includes(input)
  );
  suggestions.forEach((suggested) => {
    const div = document.createElement("div");
    div.innerHTML = suggested;
    div.classList.add("suggestion-item");
    div.addEventListener("click", () => {
      searchBox.value = suggested;
      suggestionsPanel.innerHTML = "";
    });
    suggestionsPanel.appendChild(div);
  });
  if (input === "") {
    suggestionsPanel.innerHTML = "";
  }
});
function toggleAirway(checkbox) {
  const fieldset = checkbox.closest("fieldset");
  const noRadios = fieldset.querySelectorAll('input[type="radio"][value="no"]');
  const yesRadios = fieldset.querySelectorAll(
    'input[type="radio"][value="yes"]'
  );

  // Marcar todos los radios "No" si el checkbox está seleccionado
  if (checkbox.checked) {
    noRadios.forEach((radio) => {
      radio.checked = true;
    });
  }

  // Añadir evento listener a cada radio "Sí" dentro del mismo fieldset
  yesRadios.forEach((radio) => {
    radio.addEventListener("change", () => {
      if (radio.checked) {
        // Desmarcar el checkbox si alguno de los radios "Sí" es seleccionado
        checkbox.checked = false;
      }
    });
  });
}

// Inicializar la lógica para cada radio "Sí" al cargar el documento
document.addEventListener("DOMContentLoaded", function () {
  const airwayCheckbox = document.querySelector(
    'input[name="airwayUnaltered"]'
  );
  if (airwayCheckbox) {
    const fieldset = airwayCheckbox.closest("fieldset");
    const yesRadios = fieldset.querySelectorAll(
      'input[type="radio"][value="yes"]'
    );

    yesRadios.forEach((radio) => {
      radio.addEventListener("change", () => {
        if (radio.checked) {
          airwayCheckbox.checked = false;
        }
      });
    });
  }
});

function toggleSectionCheckbox(checkbox) {
  const fieldset = checkbox.closest("fieldset");
  const radios = fieldset.querySelectorAll('input[type="radio"]');
  const radiosByGroup = groupRadiosByName(radios);

  if (checkbox.checked) {
    // Marcar todos los radios "No" si el checkbox está seleccionado
    radios.forEach((radio) => {
      if (radio.value === "no") {
        radio.checked = true;
      }
    });
  } else {
    // Verificar y marcar el checkbox si todos los radios "No" están seleccionados
    let allNoSelected = true;
    for (const radios of Object.values(radiosByGroup)) {
      if (!radios.no.checked) {
        allNoSelected = false;
        break;
      }
    }
    if (allNoSelected) {
      checkbox.checked = true;
    }
  }
}

function groupRadiosByName(radios) {
  const groups = {};
  radios.forEach((radio) => {
    const name = radio.name;
    if (!groups[name]) {
      groups[name] = {};
    }
    groups[name][radio.value] = radio;
  });
  return groups;
}

function setupSectionToggles() {
  document
    .querySelectorAll('input[type="checkbox"][name$="Unaltered"]')
    .forEach((checkbox) => {
      checkbox.addEventListener("change", () =>
        toggleSectionCheckbox(checkbox)
      );

      // Inicializar verificación para cada radio
      const fieldset = checkbox.closest("fieldset");
      const radios = fieldset.querySelectorAll('input[type="radio"]');
      radios.forEach((radio) => {
        radio.addEventListener("change", () => {
          checkbox.checked = !Array.from(radios).some(
            (radio) => radio.value === "yes" && radio.checked
          );
          toggleSectionCheckbox(checkbox);
        });
      });
    });
}

document.addEventListener("DOMContentLoaded", setupSectionToggles);

document.addEventListener("DOMContentLoaded", function () {
  const rows = document.querySelectorAll("#datosPaciente tbody tr");

  rows.forEach((row) => {
    const horaInput = row.querySelector('input[name="hora"]');
    const tasInput = row.querySelector('input[name="tas"]');
    const tadInput = row.querySelector('input[name="tad"]');
    const tamInput = row.querySelector('input[name="tam"]');

    tamInput.disabled = true; // Deshabilitar la edición manual de TAM

    row.querySelectorAll('input[type="text"]').forEach((input) => {
      if (input !== tamInput) {
        // Aplicar solo a inputs que no sean TAM
        input.addEventListener("input", () => {
          // Actualizar la hora si es necesario
          if (input.value && !horaInput.value) {
            const now = new Date();
            const hora = now.getHours().toString().padStart(2, '0');
            const minutos = now.getMinutes().toString().padStart(2, '0');
            horaInput.value = hora + ':' + minutos;
            horaInput.disabled = false; // Habilitar la edición de Hora
          }

          // Calcular TAM si TAS y TAD tienen valores
          calculateTAM(tasInput, tadInput, tamInput);

          // Comprobar si todos los campos están vacíos
          checkAllFieldsEmpty(row, horaInput);
        });

        // Permitir solo números y el símbolo '%'
        input.addEventListener("keypress", (e) => {
          if (!/[0-9%]/.test(e.key) && e.key !== "Backspace") {
            e.preventDefault();
          }
        });
      }
    });
  });

  function calculateTAM(tasInput, tadInput, tamInput) {
    const tas = parseFloat(tasInput.value);
    const tad = parseFloat(tadInput.value);
    if (!isNaN(tas) && !isNaN(tad)) {
      const tam = tad + (tas - tad) / 3;
      tamInput.value = tam.toFixed(2); // Redondear a 2 decimales
    } else {
      tamInput.value = ""; // Borrar TAM si TAS o TAD están vacíos
    }
  }

  function checkAllFieldsEmpty(row, horaInput) {
    const allEmpty = Array.from(
      row.querySelectorAll('input[type="text"]:not([name="hora"])')
    ).every((input) => !input.value.trim());
    if (allEmpty) {
      horaInput.value = "";
      horaInput.disabled = true; // Deshabilitar Hora si todos los campos están vacíos
    }
  }
});

//Inicio de casilla autocompleada de farmacos
const medicamentos = [
  "Acetazolamida",
  "Aciclovir",
  "Ácido acetilsalicílico",
  "Ácido folínico",
  "Ácido tranexámico",
  "Adenosina",
  "Adrenalina",
  "Albumina humana",
  "Alteplasa",
  "Amikacina",
  "Amiodarona",
  "Amlodipino",
  "Anfotericina B",
  "Apixabán",
  "Argatroban",
  "Aspirina",
  "Atropina",
  "Azitromicina",
  "Bicarbonato de sodio",
  "Bivalirudin",
  "Bosentan",
  "Budesonida",
  "Bupivacaína",
  "Calcio glucónato",
  "Carbamazepina",
  "Caspofungina",
  "Ceftriaxona",
  "Cetirizina",
  "Ciclofosfamida",
  "Ciprofloxacino",
  "Clindamicina",
  "Clonidina",
  "Clopidogrel",
  "Cloruro de potasio",
  "Colistina",
  "Dabigatrán",
  "Dantroleno",
  "Daptomicina",
  "Dexametasona",
  "Diazepam",
  "Digoxina",
  "Diltiazem",
  "Diphenhidramina",
  "Dobutamina",
  "Doxiciclina",
  "Doxorubicina",
  "Edoxabán",
  "Enalapril",
  "Epoprostenol",
  "Eritropoyetina",
  "Esmolol",
  "Etomidato",
  "Factor VIIa recombinante",
  "Fenitoína",
  "Fentanilo",
  "Fluconazol",
  "Flumazenil",
  "Fondaparinux",
  "Furosemida",
  "Gabapentina",
  "Gentamicina",
  "Glucagón",
  "Glucosa al %",
  "Haloperidol",
  "Heparina",
  "Hidralazina",
  "Hidrocortisona",
  "Hidroxizina",
  "Ibuprofeno",
  "Iloprost",
  "Imipenem",
  "Insulina",
  "Interferón beta",
  "Ipratropio",
  "Ketamina",
  "Lamotrigina",
  "Levetiracetam",
  "Levofloxacino",
  "Levosimendán",
  "Lidocaína",
  "Linezolid",
  "Lisinopril",
  "Loratadina",
  "Lorazepam",
  "Magnesio sulfato",
  "Mannito",
  "Meropenem",
  "Metilprednisolona",
  "Metoclopramida",
  "Metoprolol",
  "Metotrexato",
  "Metronidazol",
  "Midazolam",
  "Milrinona",
  "Morfina",
  "Naloxona",
  "Neostigmina",
  "Nifedipino",
  "Nitroglicerina",
  "Noradrenalina",
  "Octreótido",
  "Olanzapina",
  "Omeprazol",
  "Ondansetrón",
  "Oseltamivir",
  "Oxígeno",
  "Pantoprazol",
  "Paracetamol",
  "Penciclovir",
  "Piperacilina/tazobactam",
  "Piridostigmina",
  "Plasma fresco congelado",
  "Prednisolona",
  "Prednisona",
  "Pregabalina",
  "Propofol",
  "Ranitidina",
  "Reteplasa",
  "Ribavirina",
  "Ringer lactato",
  "Rivaroxabán",
  "Rocuronio",
  "Salbutamol",
  "Sildenafil",
  "Solución salina normal",
  "Streptokinasa",
  "Succinilcolina",
  "Sumatriptán",
  "Tenecteplasa",
  "Terlipresina",
  "Tigeciclina",
  "Tiopental",
  "Tirofiban",
  "Tobramicina",
  "Topiramato",
  "Trimetoprim/sulfametoxazol",
  "Urocinasa",
  "Valproato de sodio",
  "Vancomicina",
  "Vasopresina",
  "Verapamilo",
  "Vincristina",
  "Vitamina K",
  "Warfarina",
  "Zinc sulfato",
];

// Función de autocompletado
function autocomplete(inp, arr) {
  var currentFocus;
  inp.addEventListener("input", function (e) {
    var a,
      b,
      i,
      val = this.value;
    closeAllLists();
    if (!val) {
      return false;
    }
    currentFocus = -1;
    a = document.createElement("DIV");
    a.setAttribute("id", this.id + "autocomplete-list");
    a.setAttribute("class", "autocomplete-items");
    this.parentNode.appendChild(a);
    for (i = 0; i < arr.length; i++) {
      if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
        b = document.createElement("DIV");
        b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
        b.innerHTML += arr[i].substr(val.length);
        b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
        b.addEventListener("click", function (e) {
          inp.value = this.getElementsByTagName("input")[0].value;
          closeAllLists();
        });
        a.appendChild(b);
      }
    }
  });

  // Manejar las acciones del teclado
  inp.addEventListener("keydown", function (e) {
    var x = document.getElementById(this.id + "autocomplete-list");
    if (x) x = x.getElementsByTagName("div");
    if (e.keyCode == 40) {
      currentFocus++;
      addActive(x);
    } else if (e.keyCode == 38) {
      //arriba
      currentFocus--;
      addActive(x);
    } else if (e.keyCode == 13) {
      e.preventDefault();
      if (currentFocus > -1) {
        if (x) x[currentFocus].click();
      }
    }
  });
  function addActive(x) {
    if (!x) return false;
    removeActive(x);
    if (currentFocus >= x.length) currentFocus = 0;
    if (currentFocus < 0) currentFocus = x.length - 1;
    x[currentFocus].classList.add("autocomplete-active");
  }
  function removeActive(x) {
    for (var i = 0; i < x.length; i++) {
      x[i].classList.remove("autocomplete-active");
    }
  }
  function closeAllLists(elmnt) {
    var x = document.getElementsByClassName("autocomplete-items");
    for (var i = 0; i < x.length; i++) {
      if (elmnt != x[i] && elmnt != inp) {
        x[i].parentNode.removeChild(x[i]);
      }
    }
  }
  document.addEventListener("click", function (e) {
    closeAllLists(e.target);
  });
}

// Inicializar la función de autocompletado para cada casilla
autocomplete(document.getElementById("medicamento1"), medicamentos);
autocomplete(document.getElementById("medicamento2"), medicamentos);
autocomplete(document.getElementById("medicamento3"), medicamentos);
autocomplete(document.getElementById("medicamento4"), medicamentos);
autocomplete(document.getElementById("medicamento5"), medicamentos);
autocomplete(document.getElementById("medicamento6"), medicamentos);
autocomplete(document.getElementById("medicamento7"), medicamentos);
autocomplete(document.getElementById("medicamento8"), medicamentos);
autocomplete(document.getElementById("medicamento9"), medicamentos);
autocomplete(document.getElementById("medicamento10"), medicamentos);
// Repetir la inicialización del autocompletado para las demás casillas

//fin de casilla autocompleta de farmacos

//inicio de autocompletar motivo de consulta
const condiciones = [
    "Accidente moto",
    "Agresión",
    "Intoxicación - Alcohol",
    "Intoxicación - Benzodiacepinas",
    "Intoxicación - Cannabis",
    "Intoxicación - Humo",
    "Intoxicación - Opiaceos",
    "Traumatismo cráneo encefálico",
    "Absceso",
    "Accidente cerebrovascular (ACV)",
    "Accidente de tráfico",
    "Agitación psicomotriz",
    "Alergia severa",
    "Alteración del nivel de conciencia",
    "Apendicitis",
    "Arritmia",
    "Ataque de asma",
    "Bronquitis",
    "Caída",
    "Cefalea intensa",
    "Celulitis",
    "Colecistitis",
    "Cólico nefrítico",
    "Complicaciones del embarazo",
    "Complicaciones del parto",
    "Conmociones cerebrales",
    "Convulsiones",
    "Corte",
    "Crisis de ansiedad",
    "Diarrea aguda",
    "Dificultad respiratoria",
    "Distension",
    "Dolor abdominal agudo",
    "Dolor pélvico agudo",
    "Dolor torácico",
    "Embarazo ectópico",
    "Esguince",
    "Fractura",
    "Hematuria",
    "Hemorragia digestiva",
    "Hemorragia vaginal",
    "Heridas penetrante",
    "Hipertensión arterial grave",
    "Infarto de miocardio",
    "Infecciones cutáneas",
    "Infecciones del tracto urinario",
    "Infecciones respiratorias agudas",
    "Insuficiencia cardíaca",
    "Intento de suicidio",
    "Lesiones deportivas",
    "Lesiones por aplastamiento",
    "Luxacion",
    "Mordeduras de animales",
    "Neumonía",
    "Obstrucción intestinal",
    "Parto",
    "Picaduras de insectos",
    "Psicosis",
    "Quemaduras de primer grado",
    "Quemaduras de segundo grado",
    "Quemaduras de tercer grado",
    "Reacciones alérgicas graves",
    "Reacciones alérgicas",
    "Retención urinaria",
    "Síntomas de meningitis",
    "Traumatismo craneoencefálico",
    "Traumatismos oculares",
    "Vómitos intensos",
  
];

function autocompletar() {
  const input = document.getElementById("autocompleteTextbox");
  const box = document.getElementById("suggestionsBox");
  const filter = input.value.toUpperCase();

  // Limpiar las sugerencias existentes
  box.innerHTML = "";
  if (!filter) {
    box.style.display = "none";
    return;
  }

  // Filtrar y mostrar coincidencias
  const suggestions = condiciones.filter((c) =>
    c.toUpperCase().includes(filter)
  );
  if (suggestions.length === 0) {
    box.style.display = "none";
  } else {
    suggestions.forEach((suggestion) => {
      const div = document.createElement("div");
      div.innerHTML = suggestion;
      div.onclick = function () {
        input.value = this.innerText;
        box.innerHTML = "";
        box.style.display = "none";
      };
      box.appendChild(div);
    });
    box.style.display = "block";
  }
}
//fin de autocompletar motivo de consulta

//cambio de colores del sidebar
document.addEventListener("DOMContentLoaded", function () {
  // Selecciona todos los botones dentro del sidebar
  const sidebarButtons = document.querySelectorAll(".sidebar button");

  // Función para remover la clase 'active' de todos los botones
  function removeActiveClass() {
    sidebarButtons.forEach((button) => {
      button.classList.remove("active");
    });
  }

  // Añade un event listener a cada botón
  sidebarButtons.forEach((button) => {
    button.addEventListener("click", function () {
      // Remueve 'active' de todos los botones y la añade al botón clickeado
      removeActiveClass();
      this.classList.add("active");
    });
  });
});
//fin cambio de colores del sidebar

// Obtener referencias a los elementos del DOM

//Funciones de los checkboxes
var antecedentesPersonales = document.getElementById("antecedentesPersonales");
var antecedentes = document.getElementById("antecedentes");

// Agregar un event listener para el clic en el checkbox
antecedentesPersonales.addEventListener("click", function () {
  if (this.checked) {
    antecedentes.value = "No refiere";
  } else {
    antecedentes.value = "";
  }
});

// Agregar un event listener para detectar cambios en el valor del textbox
antecedentes.addEventListener("input", function () {
  if (this.value !== "No refiere") {
    antecedentesPersonales.checked = false;
  }
});

var NORAMC = document.getElementById("NORAMC");
var alergias = document.getElementById("alergias");

// Agregar un event listener para el clic en el checkbox
NORAMC.addEventListener("click", function () {
  if (this.checked) {
    alergias.value = "No refiere";
  } else {
    alergias.value = "";
  }
});

// Agregar un event listener para detectar cambios en el valor del textbox
alergias.addEventListener("input", function () {
  if (this.value !== "No refiere") {
    NORAMC.checked = false;
  }
});


  //Cambio de hora de la mediacion administrada
  function actualizarHora(input) {
    var horaInput = input.previousElementSibling;
    if (input.value.trim() !== "") {
        var now = new Date();
        var hora = now.getHours().toString().padStart(2, '0');
        var minutos = now.getMinutes().toString().padStart(2, '0');
        horaInput.value = hora + ':' + minutos;
    } else {
        horaInput.value = "";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    var medicamentoInputs = document.querySelectorAll('input[name="medicamento"]');
    medicamentoInputs.forEach(function(input) {
        input.addEventListener('input', function() {
            actualizarHora(this);
        });
    });
});

//fin de cambio de hora

//Subir la pantalla al apretar un boton
document.addEventListener('DOMContentLoaded', function() {
  const sidebarButtons = document.querySelectorAll('.sidebar button');

  sidebarButtons.forEach(button => {
      button.addEventListener('click', function() {
          window.scrollTo({
              top: 0,
              left: 0,
              behavior: 'smooth'
          });
      });
  });
});
//fin de subir pantsalla

//cambiar direccion de tabla para dispositivos moviles

//fin de cambio de direccion de tabla