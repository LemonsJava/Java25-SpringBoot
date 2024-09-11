const modalTrailer = document.getElementById("modal-trailer");
let videoTrailer = document.getElementById("video-trailer");

modalTrailer.addEventListener('hidden.bs.modal', function () {
    videoTrailer.src = videoTrailer.src;
})