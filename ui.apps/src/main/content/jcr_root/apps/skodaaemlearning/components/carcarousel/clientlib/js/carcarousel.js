/* Skoda Car Carousel — slides one card per click, loops at the ends. */
(function () {
    "use strict";

    function initCarousel(root) {
        var track = root.querySelector('[data-cmp-hook-carcarousel="track"]');
        var prevBtn = root.querySelector('[data-cmp-hook-carcarousel="prev"]');
        var nextBtn = root.querySelector('[data-cmp-hook-carcarousel="next"]');
        if (!track || !prevBtn || !nextBtn) {
            return;
        }

        var cards = track.children;
        var index = 0;

        function cardStep() {
            if (!cards.length) {
                return 0;
            }
            var style = window.getComputedStyle(track);
            var gap = parseFloat(style.gap || style.columnGap || "0") || 0;
            return cards[0].getBoundingClientRect().width + gap;
        }

        function update() {
            var max = cards.length - 1;
            if (index < 0) {
                index = max;
            }
            if (index > max) {
                index = 0;
            }
            track.style.transform = "translateX(-" + (index * cardStep()) + "px)";
        }

        prevBtn.addEventListener("click", function () {
            index -= 1;
            update();
        });
        nextBtn.addEventListener("click", function () {
            index += 1;
            update();
        });
        window.addEventListener("resize", update);
        update();
    }

    document.addEventListener("DOMContentLoaded", function () {
        var carousels = document.querySelectorAll('[data-cmp-is="carcarousel"]');
        for (var i = 0; i < carousels.length; i++) {
            initCarousel(carousels[i]);
        }
    });
})();
