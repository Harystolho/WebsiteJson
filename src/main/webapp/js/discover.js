let CATEGORY_IDS = {
    PRODUCT_HUNT: "PRODUCT_HUNT",
    REDDIT: "REDDIT",
    TWITTER: "TWITTER"
};

let Discover = (function ($) {
    let functions = {};

    /**
     * Displays the modules from the corresponding category
     * @param categoryID one from CATEGORY_IDS
     */
    functions.displayCategory = function (categoryID) {
        getModulesFromCategory(categoryID, (modules) => {
            let container = $("#category-display");
            container.children().remove();

            modules.forEach((mod) => {
                let moduleElement = createModuleElement(mod);
                container.append(moduleElement);
            });
        });
    };

    function getModulesFromCategory(categoryID, cb) {
        $.get("/api/category", {category: categoryID}).done((data) => {
            cb(data.data);
        });
    }

    functions.openModuleEndpoint = function(moduleId){
        window.open(`/module/${moduleId}`);
    };

    /**
     * Creates HTMLElement from Module object
     * @param mod
     * @return {*|HTMLElement}
     */
    function createModuleElement(mod) {
        let el = `
        <div class="category-module">
            <span onclick="Discover.openModuleEndpoint(${mod.id})">${mod.name}</span>
            <br>
            <span class="module-description">${mod.description}</span>                   
        </div>
        `;

        return $(el);
    }

    return functions;
})(jQuery);

function postshit() {
    $.post("/module/5", {a: 2, b: 4}, (data)=>{
       console.log(data);
    });
}