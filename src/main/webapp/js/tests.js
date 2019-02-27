QUnit.module("Discover Page", () => {
    QUnit.test("Request modules from an invalid category returns empty json", (assert) => {
        let done = assert.async();

        $.get("/api/category", {category: "SOME_INVALID_CATEGORY"}).done((data) => {
            done();

            assert.equal(data.error, "INVALID_CATEGORY");
        }).fail(() => {
            done();
            assert.ok(false, "Can't make GET request");
        });
    });
    QUnit.test("Request modules from a valid category", (assert) => {
        let done = assert.async();

        $.get("/api/category", {category: CATEGORY_IDS.REDDIT}).done((data) => {
            done();

            assert.equal(data.error, "NONE");
        }).fail(() => {
            done();
            assert.ok(false, "Can't make GET request");
        });
    })
});

QUnit.module("Module API", () => {
    QUnit.test("Execute module handler for an invalid category", (assert) => {
        let done = assert.async();

        $.post("/module/invalid_").done((data) => {
            done();

            assert.ok(false, "Should return an error")
        }).fail(() => {
            done();
            assert.ok(true);
        });
    });
    QUnit.test("Execute module handler for an invalid category (number)", (assert) => {
        let done = assert.async();

        $.post("/module/0000000").done((data) => {
            done();

            assert.equal(data.error, "INVALID_HANDLER");
        }).fail(() => {
            done();
            assert.ok(false, "Can't make POST request");
        });
    })
});