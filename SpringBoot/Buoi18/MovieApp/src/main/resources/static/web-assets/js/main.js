const modalTrailer = document.getElementById("modal-trailer");

modalTrailer.addEventListener('hidden.bs.modal', function () {
    let videoTrailer = document.getElementById("video-trailer");
    videoTrailer.src = videoTrailer.src;
})