QUnit.module("Discover Page", () => {
    QUnit.test("Requesting modules from an invalid category return empty json", (assert) => {
        let done = assert.async();

        $.get("/api/category", {category: "SOME_INVALID_CATEGORY"}).done((data) => {
            done();

            assert.equals(JSON.parse(data).error, "INVALID_CATEGORY");
        }).fail(() => {
            done();
            assert.ok(false, "Can't make GET request");
        });
    });
    QUnit.test("Requesting modules from a valid category", (assert) => {
        let done = assert.async();

        $.get("/api/category", {category: CATEGORY_IDS.REDDIT}).done((data) => {
            done();

            assert.equals(JSON.parse(data).error, "NONE");
        }).fail(() => {
            done();
            assert.ok(false, "Can't make GET request");
        });
    })
});

QUnit.module("Login Page", () => {
    QUnit.test("//TODO", (assert) => {
        assert.ok(true);
    })
});