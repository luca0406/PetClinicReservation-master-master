$(document).ready(() => {
    let reservationToEdit = null;

    $('#add-transaction-button').click(() => {
        if (reservationToEdit) {
            editReservation(reservationToEdit)
        } else {
            addNew()
        }
    });

    function editReservation(reservationToEdit) {
        const name = $('#modal-reservation-name').val();
        const price = $('#modal-reservation-price').val();
        const type = $('#modal-reservation-type').val();

        fetch(`/api/reservations/${reservationToEdit}`, {
            method: 'PUT',
            body: JSON.stringify({
                name: name,
                price: price,
                type: type
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload()
            } else {
                alert("There were errors " + response.status)
            }
        });
    }

    function addNew() {
        const name = $('#modal-reservation-name').val();
        const price = $('#modal-reservation-price').val();
        const type = $('#modal-reservation-type').val();

        fetch('/api/reservations', {
            method: 'POST',
            body: JSON.stringify({
                name: name,
                price: price,
                type: type
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            if (response.ok) {
                location.reload();
                clearModal();
            } else {
                alert("There were errors " + response.status)
            }

        });
    }

    function clearModal(){
        $('#modal-reservation-name').val('');
        $('#modal-reservation-price').val('');
        $('#modal-reservation-type').val('');
    }

    $('.delete-icon').click(function () {
        const reservationId = this.parentElement.id;

        fetch(`api/reservations/${reservationId}`, {
            method: 'DELETE'
        }).then(response => location.reload())
    });
    $('.edit-icon').click(function () {
        reservationToEdit = this.parentElement.id;
        const row = this.parentElement.parentElement.parentElement;
        const name = row.children[1].innerText;
        const price = row.children[2].innerText;
        const type = row.children[3].innerText;

        $('#modal-reservation-name').val(name);
        $('#modal-reservation-price').val(price);
        $('#modal-reservation-type').val(type);
    });
    $('#add-reservation-main-button').click(() => {
        clearModal();
        reservationToEdit = null
    });
});