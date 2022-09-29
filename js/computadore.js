
function traerlistaComputadores(){
  urlbase = "https://g391ce0240bc4d7-s3tk5yro4bhk3nc4.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/computer/computer";
  
  $.ajax({
    url:urlbase,
    type:"GET",
    datatype:"json",
    success:function(respuesta){
      console.log(respuesta);
      listaComputadores(respuesta.items)
    },
    error: function (xhr, status) {
      alert("hay un error");
    },
    });
  }
  
  function listaComputadores(items){
  let mytable ="<table>";
  for(i=0;i<items.length;i++){
    mytable +="<tr>";
    mytable += "<td>" +items[i].id+ "</td>";
    mytable += "<td>" +items[i].brand+ "</td>";
    mytable += "<td>" +items[i].model+ "</td>";
    mytable += "<td>" +items[i].category_id+ "</td>";
    mytable += "<td>" +items[i].name+ "</td>";
    mytable += "<td> <button onclick='borrarComputador("+ items[i].id+")'>BORRAR</button>";
    mytable += "</tr>"
  }
  mytable += "</table>";
  $("#resultado").append(mytable);
  
  }

  function guardarComputador(){
    let myData={
    id:$("#id").val(),
    brand:$("#brand").val(),
    model:$("#model").val(),
    category_id:$("#category_id").val(),
    name:$("#name").val(),
    };
    console.log(myData);
    let dataTosend=JSON.stringify(myData);
    $.ajax({
      url:urlbase,
      type:"POST",
      data:myData,
      datatype:"JSON",
      success:function(respuesta){
        $("#resultado").empty();
        $("#id").val("");
        $("#brand").val("");
        $("#model").val("");
        $("#category_id").val("");
        $("#name").val("");
        traerlistaComputadores();
        alert("se ha guardado el dato ")
      }
    });
  }

  function editarComputadores(){
    let myData={
      id:$("#id").val(),
      brand:$("#brand").val(),
      model:$("#model").val(),
      category_id:$("#category_id").val(),
      name:$("#name").val(),
      };
      console.log(myData);
      let dataTosend=JSON.stringify(myData);
      $.ajax({
        url:urlbase,
        type:"PUT",
        data:dataTosend,
        datatype:"JSON",
        success:function(respuesta){
          $("#resultado").empty();
          $("#id").val("");
          $("#brand").val("");
          $("#model").val("");
          $("#category_id").val("");
          $("#name").val("");
          traerlistaComputadores();
          alert("se ha actualizado   ")
        }
      });

  }

  function borrarComputador(idComputador){
  let myData={
  id:idComputador
  };

  let dataTosend=JSON.stringify(myData);
  $.ajax({
    url:urlbase,
      type:"DELETE",
      data:dataTosend,
      contentType:"application/JSON",
      datatype:"JSON",
      success:function(respuesta){
        $("#resultado").empty();
        traerlistaComputadores();
        alert("se ha eliminado.")
      }
  });
}
  