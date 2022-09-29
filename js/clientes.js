function leerClientes(){
  urlbase = "https://g391ce0240bc4d7-s3tk5yro4bhk3nc4.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/client/client";
  
  $.ajax({
    url:urlbase,    
    type:"GET",
    datatype:"json",
    success:function(respuesta){
      console.log(respuesta);
      listaClientes(respuesta.items)
    },
    error: function (xhr, status) {
      alert("hay un error");
    },
  });
  }
  function listaClientes(items){
    
  let mytable ="<table>";
  for(i=0;i<items.length;i++){
    mytable +="<tr>";
    mytable += "<td>" +items[i].id+ "</td>";
    mytable += "<td>" +items[i].name+ "</td>";
    mytable += "<td>" +items[i].email+ "</td>";
    mytable += "<td>" +items[i].age+ "</td>";
    mytable += "<td> <button onclick='borrarCliente("+ items[i].id+")'>BORRAR</button>";
    mytable += "</tr>"
  }
  mytable += "</table>";
  $("#resultado").append(mytable);
  
  }

  function guardarClientes(){
    let myData={
    id:$("#idCliente").val(),
    name:$("#nombreCliente").val(),
    email:$("#mailCliente").val(),
    age:$("#edadCliente").val(),
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
        $("#idCliente").val("");
        $("#nombreCliente").val("");
        $("#mailCliente").val("");
        $("#edadCliente").val("");
        leerClientes();
        alert("se ha guardado el dato ")
      }
    });
  }

  function editarClientes(){
    let myData={
      id:$("#idCliente").val(),
      name:$("#nombreCliente").val(),
      email:$("#mailCliente").val(),
      age:$("#edadCliente").val(),
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
          $("#idCliente").val("");
          $("#nombreCliente").val("");
          $("#mailCliente").val("");
          $("#edadCliente").val("");
          leerClientes();
          alert("se ha actualizado")
        }
      });

  }

  function borrarCliente(idCliente){
  let myData={
  id:idCliente
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
        leerClientes();
        alert("se ha eliminado.")
      }
  });
}
  