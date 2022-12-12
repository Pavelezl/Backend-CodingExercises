window.addEventListener('load', function () {
    (function(){

      const url = '/odontologo';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
         for(odontologo of data){
         console.log(odontologo);

            var table = document.getElementById("odontologoTable");
            var odontologoRow =table.insertRow();
            let tr_id = 'tr_' + odontologo.id;
            odontologoRow.id = tr_id;

            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                      ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                      ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-info btn_id">' +
                                      odontologo.id +
                                      '</button>';

            odontologoRow.innerHTML =
                    '<td class=\"td_id\">' + odontologo.id + '</td>' +
                    '<td>' + odontologo.matricula.toUpperCase() + '</td>' +
                    '<td class=\"td_titulo\">' + odontologo.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_categoria\">' + odontologo.apellido.toUpperCase() + '</td>' +
                    '<td>' + updateButton + '</td>' +
                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/lista_odontologo.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })