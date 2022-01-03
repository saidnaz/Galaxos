console.log("ready to use home.js")

// animation particulier gauche à droite
var scrollpos = window.scrollY;
var parti = document.getElementById("particulier")
var asso = document.getElementById("association")

function add_class_on_scroll() {
    parti.classList.add("titleToAnimate");
}

function remove_class_on_scroll() {
    parti.classList.remove("particulier_div_to_remove");
}

function add_class_on_scroll2() {
    asso.classList.add("titleToAnimateReverse");
}

function remove_class_on_scroll2() {
    asso.classList.remove("asso_div_to_remove");
}

window.addEventListener('scroll', function(){ 
    //Here you forgot to update the value
    scrollpos = window.scrollY;

    if(scrollpos > 720){
        add_class_on_scroll();
        remove_class_on_scroll();
        add_class_on_scroll2();
        remove_class_on_scroll2();
    }
    console.log(scrollpos);
});