/*                        __    __  __  __    __  ___
 *                       \  \  /  /    \  \  /  /  __/
 *                        \  \/  /  /\  \  \/  /  /
 *                         \____/__/  \__\____/__/.ɪᴏ
 * ᶜᵒᵖʸʳᶦᵍʰᵗ ᵇʸ ᵛᵃᵛʳ ⁻ ˡᶦᶜᵉⁿˢᵉᵈ ᵘⁿᵈᵉʳ ᵗʰᵉ ᵃᵖᵃᶜʰᵉ ˡᶦᶜᵉⁿˢᵉ ᵛᵉʳˢᶦᵒⁿ ᵗʷᵒ ᵈᵒᵗ ᶻᵉʳᵒ
 */
package io.vavr.match.model;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;

import static javax.lang.model.type.TypeKind.DECLARED;
import static javax.lang.model.type.TypeKind.TYPEVAR;

/**
 * Representation of a generic type parameter.
 *
 * @author Daniel Dietrich
 */
public class TypeParameterModel {

    private final Elements elementUtils;
    private final TypeMirror typeMirror;

    public TypeParameterModel(Elements elementUtils, TypeMirror typeMirror) {
        this.elementUtils = elementUtils;
        this.typeMirror = typeMirror;
    }

    public ClassModel asType() {
        return new ClassModel(elementUtils, (DeclaredType) typeMirror);
    }

    public String asTypeVar() {
        return typeMirror.toString();
    }

    public boolean isType() {
        return isTypeKind(DECLARED);
    }

    public boolean isTypeVar() {
        return isTypeKind(TYPEVAR);
    }

    private boolean isTypeKind(TypeKind typeKind) {
        return typeMirror.getKind() == typeKind;
    }

    @Override
    public boolean equals(Object o) {
        return (o == this) || (o instanceof TypeParameterModel && toString().equals(o.toString()));
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return typeMirror.toString();
    }
}
