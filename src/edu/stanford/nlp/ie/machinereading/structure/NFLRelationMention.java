package edu.stanford.nlp.ie.machinereading.structure;

import java.util.List;

import edu.stanford.nlp.util.CoreMap;

public class NFLRelationMention extends RelationMention {
  private static final long serialVersionUID = 1787269944259384225L;

  public NFLRelationMention(String objectId, 
      CoreMap sentence,
      Span span,
      String type,
      String subtype,
      List<ExtractionObject> args) {
    super(objectId, sentence, span, type, subtype, args);
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (type == null ? 0 : type.hashCode());
    result = prime * result + ((argNames == null) ? 0 : argNames.hashCode());
    result = prime * result + ((args == null) ? 0 : args.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object other) {
    // this monster code was made by Eclipse -- in summary, it compares args, argNames, and signature and calls ExtractionObject.deepEquals
    if (this == other) {
      return true;
    }
    if (!(other instanceof NFLRelationMention)) {
      return false;
    }

    NFLRelationMention otherRelation = (NFLRelationMention) other;
    
    // make sure we're equal on an ExtractionObject level -- this takes care of the spans, (sub)types, etc.
    if (! attributeEquals(otherRelation)) {
      return false;
    }
    
    if (argNames == null) {
      if (otherRelation.argNames != null) {
        return false;
      }
    } else if (!argNames.equals(otherRelation.argNames)) {
      return false;
    }
    if (args == null) {
      if (otherRelation.args != null) {
        return false;
      }
    } else if (!args.equals(otherRelation.args)) {
      return false;
    }
    if (signature == null) {
      if (otherRelation.signature != null) {
        return false;
      }
    } else if (!signature.equals(otherRelation.signature)) {
      return false;
    }
    return true;
  }
  
  /**
   * Checks equality for basic attributes, e.g., type and extent
   * This is used only by NFLRelationMention.equals()
   * @param obj
   */
  private boolean attributeEquals(NFLRelationMention other) {
    // monster code generated by Eclipse -- compares most fields
    // but modified so that sentences use == instead of .equals()
    // attributeMap and typeProbabilities are skipped

    if (this == other) {
      return true;
    }
    if (other == null) {
      return false;
    }
    
    // if the two objects have the same objectId, they are automatically
    // equal, otherwise we do more expensive checks.
    if (objectId.equals(other.objectId)) {
      return true;
    }
    
    if (extentTokenSpan == null) {
      if (other.extentTokenSpan != null) {
        return false;
      }
    } else if (!extentTokenSpan.equals(other.extentTokenSpan)) {
      return false;
    }
    if (sentence == null) {
      if (other.sentence != null) {
        return false;
      }
    } else if (sentence != other.sentence) {
      return false;
    }
    if (subType == null) {
      if (other.subType != null) {
        return false;
      }
    } else if (!subType.equals(other.subType)) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }
    return true;
  }
}