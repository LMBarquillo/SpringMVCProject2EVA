$('#modal_confirmar').on('show.bs.modal', function (event) {
  let button = $(event.relatedTarget);
  let id = button.data('id');
  let name = button.data('name');
  let modal = $(this)
  
  modal.find('#nombrerep').html(name);
  modal.find('#eliminar_link').attr("href","eliminar?id=" + id);
})