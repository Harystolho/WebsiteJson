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

            DiscoverUI.displayCategoryDisplay(true);
        });
    };

    function getModulesFromCategory(categoryID, cb) {
        $.get("/api/category", {category: categoryID}).done((data) => {
            cb(data.data);
        });
    }

    /**
     * Creates HTMLElement from Module object
     * @param mod
     * @return {*|HTMLElement}
     */
    function createModuleElement(mod) {
        let el = `
        <div class="category-module" onclick="Discover.displayModuleDocumentation(${mod.id})">
            <span>${mod.name}</span>
            <br>
            <span class="module-description">${mod.description}</span>                   
        </div>
        `;

        return $(el);
    }

    functions.displayModuleDocumentation = function (modId) {
        requestModuleInformation(modId, (data) => {
            // Display Name
            $("#module-info-name").text(data.name);

            // Display Description
            $("#module-info-description").text(data.description);

            // Display the url to use the module
            $("#module-info-id").text(`${window.location.protocol}//${window.location.host}/module/${data.id}`);

            // Display an example response
            // The server returns a string, that's why it needs the eval()
            let formattedJSONExample = JSON.stringify(eval("(" + data.jsonExample + ")"), null, "\t");
            if (formattedJSONExample !== "null") {
                $("#module-info-example-container").show();
                $("#module-json-example").text(formattedJSONExample);
            } else {
                $("#module-info-example-container").hide();
            }

            // Display Usage
            data.usageParams.length === 0 ? $("#module-info-usage-container").hide() : $("#module-info-usage-container").show();

            $(".module-table-row-container").children().remove();

            data.usageParams.forEach((param) => {
                $('.module-table-row-container').append(createModuleUsageTableRow(param));
            });


            DiscoverUI.displayCategoryDisplay(false);
        });
    };

    /**
     * Returns information about the module such as the module name, the description, the url and more information about it.
     * @param modId
     * @param cb
     */
    function requestModuleInformation(modId, cb) {
        $.get("/api/category/module", {moduleId: modId}).done((data) => {
            if (data.error === "NONE") {
                cb(data.data);
            } else {
                alert("Invalid request to /api/category/module");
            }
        });
    }

    functions.selectModuleURL = function () {
        let sel = window.getSelection();

        let range = document.createRange();
        range.selectNodeContents($("#module-info-id")[0]);

        sel.removeAllRanges();
        sel.addRange(range);
    };

    /**
     * Creates a row that can be appended to the parameters usage table in the module's info.
     *
     * @param param
     * @param info
     * @return {*|HTMLElement}
     */
    function createModuleUsageTableRow(param) {
        let el = `<div class="module-table-row">
                            <span class="module-table-row-left">${param.name}</span>
                            <div class="module-table-row-right">
                                ${param.info}
                            </div>
                        </div>`;

        return $(el);
    };

    return functions;
})(jQuery);

/**
 * This is like an util class for the discover page, it has some functions used to control the UI
 */
let DiscoverUI = (function ($) {
    let functions = {};

    /**
     * @param display if {true} shows the #category-display div, if {false} shows the #category-module-info div
     */
    functions.displayCategoryDisplay = function (display) {
        if (display) {
            $("#category-display").show();
            $("#category-module-info").hide();
        } else {
            $("#category-display").hide();
            $("#category-module-info").show();
        }
    };

    return functions;
})(jQuery);

function temp_makePost() {
    $.post("/module/4", {account: "martinfowler"}, (data) => {
        $("#category-module-info").append(`<div>${JSON.stringify(data)}</div>`);
    });
}

function temp_switchContainer() {
    let d = $("#category-display");
    let m = $("#category-module-info");

    if (d.is(":visible")) {
        d.hide();
        m.show();
    } else {
        d.show();
        m.hide();
    }

}

Discover.displayModuleDocumentation(4);